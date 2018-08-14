package com.lsp.service.Impl;

import com.lsp.core.common.TreeUtils;
import com.lsp.entity.SysMenu;
import com.lsp.entity.SysRole;
import com.lsp.mapper.SysMenuMapper;
import com.lsp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by songbo on 2018/8/2.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public Set<String> selectMenuByUserId(Long userId) {
        Set<String> result = new HashSet<String>();
        List<SysMenu> list = sysMenuMapper.selectMenuByUserId(userId);
        if(null!= list && list.size() > 0 ){
            for (SysMenu menu:list) {
                result.add(menu.getPerms());
            }
        }
        return result;
    }

    @Override
    public List<SysMenu> selectMenuTree(Long userId) {
        List<SysMenu> menuList = sysMenuMapper.selectMenuTree(userId);
        return TreeUtils.getTree(menuList);
    }
}
