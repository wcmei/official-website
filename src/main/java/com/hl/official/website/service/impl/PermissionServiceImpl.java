package com.hl.official.website.service.impl;

import com.hl.official.website.base.TkCommServiceImpl;
import com.hl.official.website.domain.Permission;
import com.hl.official.website.mapper.PermissionMapper;
import com.hl.official.website.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
@Service
public class PermissionServiceImpl extends TkCommServiceImpl<Permission, PermissionMapper> implements PermissionService {

    @Override
    public List<Permission> selectPermissionByRoleId(Long roleId) {
        List<Permission> permissions = mapper.selectPermissionByRoleId(roleId);
        return permissions;
    }
}
