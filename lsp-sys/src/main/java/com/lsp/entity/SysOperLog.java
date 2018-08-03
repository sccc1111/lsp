package com.lsp.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_oper_log")
public class SysOperLog {
    /**
     * 日志主键
     */
    @Id
    @Column(name = "oper_id")
    private Integer operId;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 功能请求
     */
    private String action;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 来源渠道（manage后台用户 mobile手机端用户 other其它）
     */
    private String channel;

    /**
     * 操作人员
     */
    @Column(name = "oper_name")
    private String operName;

    /**
     * 组织名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 请求URL
     */
    @Column(name = "oper_url")
    private String operUrl;

    /**
     * 主机地址
     */
    @Column(name = "oper_ip")
    private String operIp;

    /**
     * 操作地点
     */
    @Column(name = "oper_location")
    private String operLocation;

    /**
     * 请求参数
     */
    @Column(name = "oper_param")
    private String operParam;

    /**
     * 操作状态（0正常 1异常）
     */
    private String status;

    /**
     * 错误消息
     */
    @Column(name = "error_msg")
    private String errorMsg;

    /**
     * 操作时间
     */
    @Column(name = "oper_time")
    private Date operTime;

    /**
     * 获取日志主键
     *
     * @return oper_id - 日志主键
     */
    public Integer getOperId() {
        return operId;
    }

    /**
     * 设置日志主键
     *
     * @param operId 日志主键
     */
    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    /**
     * 获取模块标题
     *
     * @return title - 模块标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置模块标题
     *
     * @param title 模块标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取功能请求
     *
     * @return action - 功能请求
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置功能请求
     *
     * @param action 功能请求
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     * 获取方法名称
     *
     * @return method - 方法名称
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置方法名称
     *
     * @param method 方法名称
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取来源渠道（manage后台用户 mobile手机端用户 other其它）
     *
     * @return channel - 来源渠道（manage后台用户 mobile手机端用户 other其它）
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置来源渠道（manage后台用户 mobile手机端用户 other其它）
     *
     * @param channel 来源渠道（manage后台用户 mobile手机端用户 other其它）
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 获取操作人员
     *
     * @return oper_name - 操作人员
     */
    public String getOperName() {
        return operName;
    }

    /**
     * 设置操作人员
     *
     * @param operName 操作人员
     */
    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    /**
     * 获取组织名称
     *
     * @return org_name - 组织名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置组织名称
     *
     * @param orgName 组织名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 获取请求URL
     *
     * @return oper_url - 请求URL
     */
    public String getOperUrl() {
        return operUrl;
    }

    /**
     * 设置请求URL
     *
     * @param operUrl 请求URL
     */
    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl == null ? null : operUrl.trim();
    }

    /**
     * 获取主机地址
     *
     * @return oper_ip - 主机地址
     */
    public String getOperIp() {
        return operIp;
    }

    /**
     * 设置主机地址
     *
     * @param operIp 主机地址
     */
    public void setOperIp(String operIp) {
        this.operIp = operIp == null ? null : operIp.trim();
    }

    /**
     * 获取操作地点
     *
     * @return oper_location - 操作地点
     */
    public String getOperLocation() {
        return operLocation;
    }

    /**
     * 设置操作地点
     *
     * @param operLocation 操作地点
     */
    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation == null ? null : operLocation.trim();
    }

    /**
     * 获取请求参数
     *
     * @return oper_param - 请求参数
     */
    public String getOperParam() {
        return operParam;
    }

    /**
     * 设置请求参数
     *
     * @param operParam 请求参数
     */
    public void setOperParam(String operParam) {
        this.operParam = operParam == null ? null : operParam.trim();
    }

    /**
     * 获取操作状态（0正常 1异常）
     *
     * @return status - 操作状态（0正常 1异常）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置操作状态（0正常 1异常）
     *
     * @param status 操作状态（0正常 1异常）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取错误消息
     *
     * @return error_msg - 错误消息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误消息
     *
     * @param errorMsg 错误消息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    /**
     * 获取操作时间
     *
     * @return oper_time - 操作时间
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * 设置操作时间
     *
     * @param operTime 操作时间
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }
}