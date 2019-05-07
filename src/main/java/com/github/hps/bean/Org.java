package com.github.hps.bean;

import java.sql.Timestamp;
import java.util.List;

public class Org {
    private Long orgId;//部门ID

    private Long parentOrgId;//父部门ID

    private String parentOrgNm;//父部门名称

    private Long regionCode;//行政区划编码

    private Long orgCd;//部门编码
    private String orgCD;
    private String orgCds;//导出部门编码
    private Long orgCdFlag;//部门编码

    private Long parOrgCd;//上级节点编码
    private String parOrgNm;//上级节点编码

    private String orgNm;//部门名称
    private String orgNmStr;//部门名称

    private String orgsNm;//部门简称

    private String orgUser;//部门负责人

    private Integer orgType;//部门类型(1:口服液 2：针剂),只在南北区进行维护，南北区下属部门继承南北区  "ORGTYPE0"

    private String orgcTypeCd;//部门分类字典编码：ORGAKIND

    private Integer orgcType;// 部门分类

    private String orgcTypeNm;

    private String orgrkindCd;//地办分类字典编码：ORGRKIND

    private Integer orgrkind;// 地办分类

    private String orgrkindNm;

    private String address;//地址

    private Double longitude;//位置经度

    private Double latitude;//位置纬度

    private String contact;//联系人

    private String phone;//联系电话
    private String phone1;//负责人电话

    private String remark;//备注

    private Integer isEnabled = 1;//是否启用

    private Long creator;//创建人

    private Timestamp creationTime;//创建时间

    private Long modifier;//最后一次更新人

    private Timestamp modifyTime;//最后一次更新时间

    private Integer isInteragent;//是否内部代理商
    private String isInteragentNm;//是否内部代理商

    private Integer province;//省
    private Integer city;//市
    private Integer area;//区
    private String employeeNm;//员工中文姓名

    private Long employeeCd;//员工码
    private Integer orgNType;//办事处分类
    private Integer orgRGrade;//代理商级别
    private String orgTypeNm;
    private String orgNTypeNm;//办事处分类
    private String orgRGradeNm;//代理商级别


    private Long countyOffice ;//归属地办
    private String countyOfficeNm ;//归属地办
    private String countOfficeManage; //归属办事处经理
    private List<String> factoryProductList; //药厂拼接字符串
    private Long fOrgId; //查询orgId 专为部门销售区域管理使用
    public List<Region> regionList;

    private String chineseCode;//助记码

    private String orgIds;
    private String orgNms;


    public String getCountyOfficeNm() {
        return countyOfficeNm;
    }

    public void setCountyOfficeNm(String countyOfficeNm) {
        this.countyOfficeNm = countyOfficeNm;
    }

    public Long getCountyOffice() {
        return countyOffice;
    }

    public void setCountyOffice(Long countyOffice) {
        this.countyOffice = countyOffice;
    }

    public void setOrgNTypeNm(String orgNTypeNm) {
        this.orgNTypeNm = orgNTypeNm;
    }



    public void setOrgRGradeNm(String orgRGradeNm) {
        this.orgRGradeNm = orgRGradeNm;
    }

    public void setOrgTypeNm(String orgTypeNm) {
        this.orgTypeNm = orgTypeNm;
    }

    public Integer getOrgRGrade() {
        return orgRGrade;
    }

    public void setOrgRGrade(Integer orgRGrade) {
        this.orgRGrade = orgRGrade;
    }

    public Integer getOrgNType() {
        return orgNType;
    }

    public void setOrgNType(Integer orgNType) {
        this.orgNType = orgNType;
    }



    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    public String getOrgNmStr() {
        return orgNmStr;
    }

    public void setOrgNmStr(String orgNmStr) {
        this.orgNmStr = orgNmStr;
    }

    public String getEmployeeNm() {
        return employeeNm;
    }

    public void setEmployeeNm(String employeeNm) {
        this.employeeNm = employeeNm;
    }

    public Long getEmployeeCd() {
        return employeeCd;
    }

    public void setEmployeeCd(Long employeeCd) {
        this.employeeCd = employeeCd;
    }

    public Long getParOrgCd() {
        return parOrgCd;
    }

    public void setParOrgCd(Long parOrgCd) {
        this.parOrgCd = parOrgCd;
    }

    public String getParOrgNm() {
        return parOrgNm;
    }

    public void setParOrgNm(String parOrgNm) {
        this.parOrgNm = parOrgNm;
    }



    public void setOrgCds(String orgCds) {
        this.orgCds = orgCds;
    }



    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone() {
        return phone;
    }

    public String getContact() {
        return contact;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsInteragent() {
        return isInteragent;
    }

    public void setIsInteragentNm(String isInteragentNm) {
        this.isInteragentNm = isInteragentNm;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public void setOrgCd(Long orgCd) {
        this.orgCd = orgCd;
    }

    public void setOrgCD(String orgCD) {
        this.orgCD = orgCD;
    }

    public Long getOrgCdFlag() {
        return orgCdFlag;
    }

    public void setOrgCdFlag(Long orgCdFlag) {
        this.orgCdFlag = orgCdFlag;
    }

    public void setIsInteragent(Integer isInteragent) {
        this.isInteragent = isInteragent;
    }

    public void setOrgrkindNm(String orgrkindNm) {
        this.orgrkindNm = orgrkindNm;
    }

    public String getParentOrgNm() {
        return parentOrgNm;
    }

    public String getOrgNms() {
        return orgNms;
    }

    public void setOrgcTypeNm(String orgcTypeNm) {
        this.orgcTypeNm = orgcTypeNm;
    }

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }

    public void setOrgNms(String orgNms) {
        this.orgNms = orgNms;
    }

    public void setOrgsNm(String orgsNm) {
        this.orgsNm = orgsNm;
    }

    public void setOrgUser(String orgUser) {
        this.orgUser = orgUser;
    }

    public String getChineseCode() {
        return chineseCode;
    }

    public void setChineseCode(String chineseCode) {
        this.chineseCode = chineseCode;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public void setParentOrgNm(String parentOrgNm) {
        this.parentOrgNm = parentOrgNm;
    }

    public String getOrgrkindCd() {
        return orgrkindCd;
    }

    public void setOrgrkindCd(String orgrkindCd) {
        this.orgrkindCd = orgrkindCd;
    }

    public Integer getOrgrkind() {
        return orgrkind;
    }

    public void setOrgrkind(Integer orgrkind) {
        this.orgrkind = orgrkind;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    public String getOrgcTypeCd() {
        return orgcTypeCd;
    }

    public void setOrgcTypeCd(String orgcTypeCd) {
        this.orgcTypeCd = "ORGAKIND";
    }

    public Integer getOrgcType() {
        return orgcType;
    }

    public void setOrgcType(Integer orgcType) {
        this.orgcType = orgcType;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public static void sortList(List<Org> result, List<Org> sourceList, Long parentId) {
        for (int i = 0; i < sourceList.size(); i++) {
            Org o = sourceList.get(i);
            if (o.getParentOrgId() != null && o.getParentOrgId().equals(parentId)) {
                result.add(o);
                // 判断是否还有子节点, 有则继续获取子节点
                for (int j = i; j < sourceList.size(); j++) {
                    Org child = sourceList.get(j);
                    if (child.getParentOrgId() != null && child.getParentOrgId().equals(o.getOrgId())) {
                        sortList(result, sourceList, o.getOrgId());
                        break;
                    }
                }
            }
        }
    }


    public List<String> getFactoryProductList() {
        return factoryProductList;
    }

    public void setFactoryProductList(List<String> factoryProductList) {
        this.factoryProductList = factoryProductList;
    }

    public String getCountOfficeManage() {
        return countOfficeManage;
    }

    public void setCountOfficeManage(String countOfficeManage) {
        this.countOfficeManage = countOfficeManage;
    }

    public Long getfOrgId() {
        return fOrgId;
    }

    public void setfOrgId(Long fOrgId) {
        this.fOrgId = fOrgId;
    }

    public String getOrgNm() {
        return orgNm;
    }
}
