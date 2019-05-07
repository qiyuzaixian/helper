package com.github.hps.bean;

import java.sql.Timestamp;

public class Role {

    private Integer rn;//分页编号

    private Long roleId;//角色ID

    private String roleName;//角色名称

    private Integer dpermissionValue;//数据权限值（CODE:DATESCOP   value: 1:所有数据 2:部门和所属部门数据 3:部门数据 4:个人数据）

    private Integer isSysSet;//是否系统设置

    private Integer isEnabled;//数据状态

    private Long creator;//创建人

    private Timestamp creationTime;//创建时间

    private Long modifier;//最后一次更新人

    private Timestamp modifyTime;//最后一次更新时间

    private String chineseCode;//助记码

    private Integer isManagerRole;//是否部门负责人

    private Integer isDailyAssessment;//是否考核日报

    private Integer rolekind;//岗位分类

    private Integer jobkd;//岗位级别

    private Integer token = 0;

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDpermissionValue() {
        return dpermissionValue;
    }

    public void setDpermissionValue(Integer dpermissionValue) {
        this.dpermissionValue = dpermissionValue;
    }

    public Integer getIsSysSet() {
        return isSysSet;
    }

    public void setIsSysSet(Integer isSysSet) {
        this.isSysSet = isSysSet;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getChineseCode() {
        return chineseCode;
    }

    public void setChineseCode(String chineseCode) {
        this.chineseCode = chineseCode;
    }

    public Integer getIsManagerRole() {
        return isManagerRole;
    }

    public void setIsManagerRole(Integer isManagerRole) {
        this.isManagerRole = isManagerRole;
    }

    public Integer getIsDailyAssessment() {
        return isDailyAssessment;
    }

    public void setIsDailyAssessment(Integer isDailyAssessment) {
        this.isDailyAssessment = isDailyAssessment;
    }

    public Integer getRolekind() {
        return rolekind;
    }

    public void setRolekind(Integer rolekind) {
        this.rolekind = rolekind;
    }

    public Integer getJobkd() {
        return jobkd;
    }

    public void setJobkd(Integer jobkd) {
        this.jobkd = jobkd;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }
}
