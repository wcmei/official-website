package com.hl.official.website.base;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author wcmei
 * @date 2020-01-11
 * @description
 */
@Data
@MappedSuperclass
public abstract class AbstractBaseDomain implements Domain {

    @Id
    private Long id;

    private String created;

    private String updated;

}
