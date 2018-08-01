package com.lsp.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_notice")
public class SysNotice {
    /**
     * 公告ID
     */
    @Id
    @Column(name = "notice_id")
    private Integer noticeId;

    /**
     * 公告标题
     */
    @Column(name = "notice_title")
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    @Column(name = "notice_type")
    private String noticeType;

    /**
     * 公告内容
     */
    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取公告ID
     *
     * @return notice_id - 公告ID
     */
    public Integer getNoticeId() {
        return noticeId;
    }

    /**
     * 设置公告ID
     *
     * @param noticeId 公告ID
     */
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * 获取公告标题
     *
     * @return notice_title - 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 设置公告标题
     *
     * @param noticeTitle 公告标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    /**
     * 获取公告类型（1通知 2公告）
     *
     * @return notice_type - 公告类型（1通知 2公告）
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * 设置公告类型（1通知 2公告）
     *
     * @param noticeType 公告类型（1通知 2公告）
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    /**
     * 获取公告内容
     *
     * @return notice_content - 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 设置公告内容
     *
     * @param noticeContent 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    /**
     * 获取公告状态（0正常 1关闭）
     *
     * @return status - 公告状态（0正常 1关闭）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置公告状态（0正常 1关闭）
     *
     * @param status 公告状态（0正常 1关闭）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}