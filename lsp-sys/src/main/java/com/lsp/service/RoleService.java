package com.lsp.service;

import java.util.Set;

/**
 * Created by songbo on 2018/8/1.
 */
public interface RoleService {

    public Set<String> selectRoleByUserId(Long userId);

}
