package com.lsp.service;

import com.lsp.entity.SysUser;

import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
public interface UserService {


    SysUser selectUserByUserName(String userName);

    List<SysUser> selectUserList(SysUser user);

    int add(SysUser user);
}
