package com.lsp.mapper;

import com.lsp.entity.SysRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole,Integer> {

    List<SysRole> selectRoleByUserId(Long userId);

}