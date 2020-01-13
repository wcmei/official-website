package com.hl.official.website.controller;

import com.google.common.collect.Maps;
import com.hl.official.website.base.BaseResult;
import com.hl.official.website.config.BaseUserDetails;
import com.hl.official.website.domain.User;
import com.hl.official.website.service.RedisService;
import com.hl.official.website.service.UserService;
import com.hl.official.website.utils.MapperUtils;
import com.hl.official.website.utils.OkHttpClientUtils;
import io.swagger.annotations.Api;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
@Api(description = "登录接口")
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:8765/oauth/token";

    @Value("${config.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${config.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${config.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public TokenStore tokenStore;

    @Autowired
    RedisService redisService;

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public BaseResult login(String userAccount, String password) {

        Map<String, Object> result = Maps.newHashMap();
        BaseUserDetails userDetails = (BaseUserDetails) userDetailsService.loadUserByUsername(userAccount);
        if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return BaseResult.fail(1, "用户名或密码错误");
        }

        Map<String, String> params = Maps.newHashMap();
        params.put("username", userAccount);
        params.put("password", password);
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);

        try {
            //oauth_client_details表
            Response response = OkHttpClientUtils.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseResult.success(result);
    }

    @GetMapping("/user/info")
    public BaseResult info() throws Exception {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return BaseResult.success(authentication.getPrincipal());

    }

    @PostMapping("/user/logout")
    public BaseResult logout(HttpServletRequest request) {
        // 获取token
        String token = request.getParameter("access_token");
        // 删除token, 进行注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return BaseResult.success("用户已注销");
    }

    @PostMapping("/test")
    public BaseResult test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
//        User user = userService.selectUserByUserAccount((String) authentication.getPrincipal());
        return BaseResult.success(principal);
    }

    // 查询用户
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.selectUserByUserAccount((String) authentication.getPrincipal());
        return user;
    }

}
