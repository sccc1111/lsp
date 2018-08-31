package com.lsp.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_city")
public class SysCity {
    @Id
    @Column(name = "CITY_ID")
    private Integer cityId;

    @Column(name = "CITY_LEVEL")
    private Integer cityLevel;

    @Column(name = "SUPERIOR_CITY_CODE")
    private String superiorCityCode;

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "JANE_SPELL")
    private String janeSpell;

    @Column(name = "REGIONAL_CODE")
    private String regionalCode;

    @Column(name = "SORT_NO")
    private Integer sortNo;

    @Column(name = "AREA_ID")
    private String areaId;

    @Column(name = "INSERT_USER_ID")
    private String insertUserId;

    @Column(name = "UPDATE_USER_ID")
    private String updateUserId;

    @Column(name = "INSERT_TIME")
    private Date insertTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * @return CITY_ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * @return CITY_LEVEL
     */
    public Integer getCityLevel() {
        return cityLevel;
    }

    /**
     * @param cityLevel
     */
    public void setCityLevel(Integer cityLevel) {
        this.cityLevel = cityLevel;
    }

    /**
     * @return SUPERIOR_CITY_CODE
     */
    public String getSuperiorCityCode() {
        return superiorCityCode;
    }

    /**
     * @param superiorCityCode
     */
    public void setSuperiorCityCode(String superiorCityCode) {
        this.superiorCityCode = superiorCityCode == null ? null : superiorCityCode.trim();
    }

    /**
     * @return CITY_CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * @return CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * @return JANE_SPELL
     */
    public String getJaneSpell() {
        return janeSpell;
    }

    /**
     * @param janeSpell
     */
    public void setJaneSpell(String janeSpell) {
        this.janeSpell = janeSpell == null ? null : janeSpell.trim();
    }

    /**
     * @return REGIONAL_CODE
     */
    public String getRegionalCode() {
        return regionalCode;
    }

    /**
     * @param regionalCode
     */
    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode == null ? null : regionalCode.trim();
    }

    /**
     * @return SORT_NO
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * @param sortNo
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * @return AREA_ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * @return INSERT_USER_ID
     */
    public String getInsertUserId() {
        return insertUserId;
    }

    /**
     * @param insertUserId
     */
    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId == null ? null : insertUserId.trim();
    }

    /**
     * @return UPDATE_USER_ID
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * @param updateUserId
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    /**
     * @return INSERT_TIME
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}