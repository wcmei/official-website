package com.hl.official.website.service;


import com.hl.official.website.base.BaseCommService;
import com.hl.official.website.domain.User;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
public interface UserService extends BaseCommService<User> {
    //根据账号查找用户
    User selectUserByUserAccount(String userAccount);
}
