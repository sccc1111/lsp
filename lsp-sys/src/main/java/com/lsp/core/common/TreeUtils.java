package com.lsp.core.common;

import com.lsp.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songbo on 2018/8/13.
 */
public class TreeUtils {
    public static List<SysMenu> getTree(List<SysMenu> menuList){
        List<SysMenu> list = new ArrayList<>();
        if(null == menuList || menuList.size() == 0 ){
            return list;
        }
        //取得目录
        for(SysMenu menu:menuList){
            if(0 == menu.getParentId()){
                getChild(menu,menuList);
                list.add(menu);
            }
        }
        return list;
    }

    //循环查找子节点
    public static void getChild(SysMenu menu,List<SysMenu> menuList){
        List<SysMenu> list = new ArrayList<>();
        for(SysMenu m:menuList){
            if(menu.getMenuId() == m.getParentId()){
                getChild(m,menuList);
                list.add(m);
            }
        }
        if(null != list && list.size() >0){
            menu.setChildren(list);
        }
    }
}
