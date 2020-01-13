package com.hl.official.website.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wcmei
 * @date 2020-01-11
 * @description
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
