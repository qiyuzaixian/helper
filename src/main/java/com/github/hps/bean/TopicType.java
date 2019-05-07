package com.github.hps.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 题型信息对应的实体类
 * Created by whatlookingfor-Jonathan on 16/1/20 11:33.
 */
public class TopicType implements Serializable {

    private Long topicTypeId;//题型ID

    private String topicTypeNm;//题型名称

    private Integer markingKd;//阅卷方式

    private Integer isEnabled;//是否启用

    private Long creator;//创建人

    private Timestamp creationTime;//创建时间

    private Long modifier;//最后一次更新人

    private Timestamp modifyTime;//最后一次更新时间


    public Long getTopicTypeId() {
        return topicTypeId;
    }

    public void setTopicTypeId(Long topicTypeId) {
        this.topicTypeId = topicTypeId;
    }

    public String getTopicTypeNm() {
        return topicTypeNm;
    }

    public void setTopicTypeNm(String topicTypeNm) {
        this.topicTypeNm = topicTypeNm;
    }

    public Integer getMarkingKd() {
        return markingKd;
    }

    public void setMarkingKd(Integer markingKd) {
        this.markingKd = markingKd;
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
}
