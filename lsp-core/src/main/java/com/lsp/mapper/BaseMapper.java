package com.lsp.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.io.Serializable;

/**
 * Created by songbo on 2018/8/1.
 */
public interface BaseMapper<T, E extends Serializable> extends tk.mybatis.mapper.common.BaseMapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
