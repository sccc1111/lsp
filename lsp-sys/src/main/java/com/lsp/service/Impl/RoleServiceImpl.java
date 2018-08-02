package com.lsp.service.Impl;

import com.lsp.entity.SysRole;
import com.lsp.mapper.SysRoleMapper;
import com.lsp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by songbo on 2018/8/2.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> selectRoleByUserId(Long userId) {
        Set<String> result = new HashSet<String>();
        List<SysRole> list = sysRoleMapper.selectRoleByUserId(userId);
        if(null!= list && list.size() > 0 ){
            for (SysRole role:list) {
                result.add(role.getRoleId().toString());
            }
        }
        return result;
    }
}
