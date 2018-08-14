package com.lsp.mapper;

import com.lsp.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> selectMenuByUserId(Long userId);

    List<SysMenu> selectMenuTree(Long userId);
}