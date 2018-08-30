package com.lsp.service;

import com.lsp.entity.SysDictData;
import com.lsp.entity.SysUser;

import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
public interface DictService {
    List<SysDictData> selectDictListByCode(String code);
}
