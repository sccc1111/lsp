package com.lsp.dto;

import com.lsp.entity.SysMenu;
import com.lsp.entity.SysRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 4618627882808240291L;

    private String id;
    private String username;
    private String loginName;
    private String password;
    private String email;
    private String phonenumber;
    private String sex;
    private String avatar;
    private String salt;
    private String status;

    private List<SysRole> roleList;

    private List<SysMenu> menuList;
}
