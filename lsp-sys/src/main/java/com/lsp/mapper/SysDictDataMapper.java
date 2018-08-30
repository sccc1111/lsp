package com.lsp.mapper;

import com.lsp.entity.SysCron;
import com.lsp.entity.SysDictData;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    List<SysDictData> selectDictListByCode(String code);
}