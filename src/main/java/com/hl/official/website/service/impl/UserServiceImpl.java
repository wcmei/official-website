package com.hl.official.website.service.impl;

import com.hl.official.website.base.TkCommServiceImpl;
import com.hl.official.website.domain.User;
import com.hl.official.website.mapper.UserMapper;
import com.hl.official.website.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
@Service
public class UserServiceImpl extends TkCommServiceImpl<User, UserMapper> implements UserService {

    @Override
    public User selectUserByUserAccount(String userAccount) {
        User user = new User();
        user.setUserAccount(userAccount);
        User oneUser = mapper.selectOne(user);
        return oneUser;
    }
}
