package com.github.hps.bean;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 题库信息实体类
 * Created by YangMi on 2015/6/5.i
 * update by 张展 2016-02-19
 */
public class Questions implements Serializable {

    private static final long serialVersionUID = 4406338487472850271L;

    private Integer rn;//分页编号

    private Long questionId;//题目ID

    private TopicType topicType;//题型信息

    private String title;//题目

    private String kPoints;//知识点

    private String kPointIds;//知识点ID

    private Integer difficulty;//题目难度

    private Integer pumPingTimes;//抽中次数

    private String result;//答案

    private Integer isEnabled;//是否启用

    private Long creator;//创建人

    private Timestamp creationTime;//创建时间

    private Long modifier;//最后一次更新人

    private Timestamp modifyTime;//最后一次更新时间

    private List<QuestionsD> questionsDList;//答案详情

    private List<Kpoint> kpointList;//对应的知识点



    public Questions() {
        this.pumPingTimes = 0;
        this.isEnabled = 1;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public String getkPointIds() {
        return kPointIds;
    }

    public void setkPointIds(String kPointIds) {
        this.kPointIds = kPointIds;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
        this.topicType = topicType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getkPoints() {
        return kPoints;
    }

    public void setkPoints(String kPoints) {
        this.kPoints = kPoints;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getPumPingTimes() {
        return pumPingTimes;
    }

    public void setPumPingTimes(Integer pumPingTimes) {
        this.pumPingTimes = pumPingTimes;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public List<QuestionsD> getQuestionsDList() {
        return questionsDList;
    }

    public void setQuestionsDList(List<QuestionsD> questionsDList) {
        this.questionsDList = questionsDList;
    }

    public List<Kpoint> getKpointList() {
        return kpointList;
    }

    public void setKpointList(List<Kpoint> kpointList) {
        this.kpointList = kpointList;
    }
}


