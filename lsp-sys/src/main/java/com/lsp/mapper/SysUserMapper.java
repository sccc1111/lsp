package com.lsp.mapper;

import com.lsp.entity.SysUser;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectUserByUserName(String userName);

    List<SysUser> selectUserList(SysUser user);
}