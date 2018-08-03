package com.lsp.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user_post")
public class SysUserPost {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 岗位ID
     */
    @Id
    @Column(name = "post_id")
    private String postId;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取岗位ID
     *
     * @return post_id - 岗位ID
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 设置岗位ID
     *
     * @param postId 岗位ID
     */
    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }
}