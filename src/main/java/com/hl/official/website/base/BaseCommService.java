package com.hl.official.website.base;


/**
 * @author wcmei
 * @date 2020-01-11
 * @description
 */
public interface BaseCommService<T extends AbstractBaseDomain> {

    //新增对象
    void insertDomain(T domain);

    //更新对象
    void updateDomain(T domain);

    //根据id删除对象
    void deleteDomainById(Long id);

    //根据id查询对象
    T selectDomainById(Long id);

}
