package com.lsp.service.Impl;

import com.lsp.entity.SysUser;
import com.lsp.mapper.SysUserMapper;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUserName(String userName) {
        return sysUserMapper.selectUserByUserName(userName);
    }

    @Override
    public List<SysUser> selectUserList(SysUser user) {
        return sysUserMapper.selectUserList(user);
    }

    @Override
    public int add(SysUser user) {
        return sysUserMapper.insert(user);
    }
}
