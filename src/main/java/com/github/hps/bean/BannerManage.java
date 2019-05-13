package com.github.hps.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ZhangChao
 * @description banner实体类
 * @date 2019/5/10
 */
public class BannerManage implements Serializable {
    private  Long bannerId;
    private  Long orgId;
    private  Long creator;
    private  Date creationTime;
    private  Long modifier;
    private  Date modifyTime;
    private  Integer isEnabled;
    private  Integer orderNum; // 序号
    private  String photo;
    private String photoNew;


    public String getPhotoNew() {
        return photoNew;
    }

    public void setPhotoNew(String photoNew) {
        this.photoNew = photoNew;
    }

    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "BannerManage{" +
                "bannerId=" + bannerId +
                ", orgId=" + orgId +
                ", creator=" + creator +
                ", creationTime=" + creationTime +
                ", modifier=" + modifier +
                ", modifyTime=" + modifyTime +
                ", isEnabled=" + isEnabled +
                ", orderNum=" + orderNum +
                ", photo='" + photo + '\'' +
                '}';
    }
}
