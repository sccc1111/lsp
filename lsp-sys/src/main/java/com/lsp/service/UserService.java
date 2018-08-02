package com.lsp.service;

import com.lsp.entity.SysUser;

/**
 * Created by songbo on 2018/8/2.
 */
public interface UserService {
    SysUser selectUserByUserName(String userName);
}
