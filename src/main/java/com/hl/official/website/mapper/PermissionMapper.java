package com.hl.official.website.mapper;

import com.hl.official.website.base.MyMapper;
import com.hl.official.website.domain.Permission;

import java.util.List;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
public interface PermissionMapper extends MyMapper<Permission> {

    //根据角色id查询权限
    List<Permission> selectPermissionByRoleId(Long roleId);
}
