package com.lsp.service.Impl;

import com.lsp.entity.SysDictData;
import com.lsp.entity.SysUser;
import com.lsp.mapper.SysDictDataMapper;
import com.lsp.mapper.SysUserMapper;
import com.lsp.service.DictService;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private SysDictDataMapper sysDictMapper;

    @Override
    public List<SysDictData> selectDictListByCode(String code) {
        return sysDictMapper.selectDictListByCode(code);
    }
}
