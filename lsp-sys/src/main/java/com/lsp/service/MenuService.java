package com.lsp.service;

import com.lsp.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
 * Created by songbo on 2018/8/1.
 */
public interface MenuService {

    Set<String> selectMenuByUserId(Long userId);

    List<SysMenu> selectMenuTree(Long userId);
}
