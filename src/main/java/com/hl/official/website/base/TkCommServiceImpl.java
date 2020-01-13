package com.hl.official.website.base;

import com.hl.official.website.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wcmei
 * @date 2020-01-11
 * @description
 */
public class TkCommServiceImpl<T extends AbstractBaseDomain, M extends tk.mybatis.mapper.common.Mapper<T> & tk.mybatis.mapper.common.MySqlMapper<T>> implements BaseCommService<T> {

    @Autowired
    protected M mapper;

//    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public void insertDomain(T domain) {
        String created = DateUtil.getCurrSecDateTimeToString();
        domain.setCreated(created);
        mapper.insert(domain);
    }

    @Override
    public void updateDomain(T domain) {
        String updated = DateUtil.getCurrSecDateTimeToString();
        domain.setUpdated(updated);
        mapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public void deleteDomainById(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectDomainById(Long id) {
        T domain = mapper.selectByPrimaryKey(id);
        return domain;
    }
}
