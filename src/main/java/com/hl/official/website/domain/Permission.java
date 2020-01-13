package com.hl.official.website.domain;


import com.hl.official.website.base.AbstractBaseDomain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wcmei
 * @date 2019-12-17
 * @description
 */
@Data
@Entity
@Table(name = "tb_base_permission")
public class Permission extends AbstractBaseDomain {

    private String permissionName;//名称
}
