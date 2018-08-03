package com.lsp.mapper;

import com.lsp.entity.SysUser;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectUserByUserName(String userName);
}