package com.lsp.mapper;

import com.lsp.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu,Integer> {
    List<SysMenu> selectMenuByUserId(Long userId);
}