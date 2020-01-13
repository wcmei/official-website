package com.hl.official.website.domain;

import com.hl.official.website.base.AbstractBaseDomain;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_base_user")
public class User extends AbstractBaseDomain {
    private Long id;

    private String created;

    private String updated;

    private String userName;

    private String userAccount;

    private String password;

    private Long roleId;
}