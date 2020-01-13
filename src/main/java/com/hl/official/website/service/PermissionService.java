package com.hl.official.website.service;


import com.hl.official.website.base.BaseCommService;
import com.hl.official.website.domain.Permission;

import java.util.List;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
public interface PermissionService extends BaseCommService<Permission> {

    //根据角色id查询权限
    List<Permission> selectPermissionByRoleId(Long roleId);
}
