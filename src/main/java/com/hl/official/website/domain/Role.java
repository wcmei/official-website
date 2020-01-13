package com.hl.official.website.domain;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_base_role")
public class Role {
    private Long id;

    private String created;

    private String updated;

    private String roleName;

}