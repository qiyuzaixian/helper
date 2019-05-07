package com.github.hps.bean;

public class Region {

    private Integer provinceId;//前两位（省）ID
    private Integer cityId;//前两位（市）ID
    private Integer areaId;//后两位（市）ID
    private Long regionCode;//区域ID
    private String regionNm;//区域名称
    private Integer regionLevel;//行政区划分类
    private String regionlvCd;//行政区划级别编码(REGIONLV)
    private Integer regionLv;//区划级别(1：省(直辖市) 2:市(地区)  3:县)
    private Integer isprocapital;//是否省会城市(1:是 0：否)
    private String regionFNm;//行政区全名
    private String areaFID;//两位ID

    public String getRegionlvCd() {
        return regionlvCd;
    }

    public void setRegionlvCd(String regionlvCd) {
        this.regionlvCd = regionlvCd;
    }

    public Integer getRegionLv() {
        return regionLv;
    }

    public void setRegionLv(Integer regionLv) {
        this.regionLv = regionLv;
    }

    public Integer getIsprocapital() {
        return isprocapital;
    }

    public void setIsprocapital(Integer isprocapital) {
        this.isprocapital = isprocapital;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getRegionFNm() {
        return regionFNm;
    }

    public void setRegionFNm(String regionFNm) {
        this.regionFNm = regionFNm;
    }

    public String getAreaFID() {
        return areaFID;
    }

    public void setAreaFID(String areaFID) {
        this.areaFID = areaFID;
    }
}
