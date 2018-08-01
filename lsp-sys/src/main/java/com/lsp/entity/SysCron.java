package com.lsp.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_cron")
public class SysCron {
    @Id
    private Integer id;

    private String name;

    private String tgroup;

    private String description;

    @Column(name = "className")
    private String classname;

    private String expression;

    private String status;

    @Column(name = "createTime")
    private Date createtime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return tgroup
     */
    public String getTgroup() {
        return tgroup;
    }

    /**
     * @param tgroup
     */
    public void setTgroup(String tgroup) {
        this.tgroup = tgroup == null ? null : tgroup.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return className
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param classname
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * @return expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * @param expression
     */
    public void setExpression(String expression) {
        this.expression = expression == null ? null : expression.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}