package com.github.hps.bean;


import java.io.Serializable;
import java.util.List;

/**
 * 考试管理  卷库题型信息  PaperQustKD
 * Created by LZY on 2016/1/26.
 */
public class PaperQustKD implements Serializable {


    private static final long serialVersionUID = 7502408696590877686L;

    private Long paperId;   //试卷ID
    private Long examId;//              number(12)           not null,
    private Long qustkSeq;//   da题序号          number(6)            not null,
    private Long topicTypeId;//  题型ID        number(6),
    private String topicTypeNM;
    private String title;//      大题标题          varchar2(64)         not null,
    private Integer totalScore;//  总分         number(3),
    private Integer scorepq;//   每题分数           number(2),
    private Integer questQty;//   题目数量          number(3),
    private String kPoints;//    知识点          varchar2(256),
    private Integer difficulty1Type;// 难度1类型     number(1),
    private Integer difficulty1Qty;//   难度1类型数量    number(3),
    private Integer difficulty2Type;//      number(1),
    private Integer difficulty2Qty;//       number(3),
    private Integer difficulty3Type;//      number(1),
    private Integer difficulty3Qty;//       number(3),

    private List<PaperContent> paperContentList;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getQustkSeq() {
        return qustkSeq;
    }

    public void setQustkSeq(Long qustkSeq) {
        this.qustkSeq = qustkSeq;
    }

    public Long getTopicTypeId() {
        return topicTypeId;
    }

    public void setTopicTypeId(Long topicTypeId) {
        this.topicTypeId = topicTypeId;
    }

    public String getTopicTypeNM() {
        return topicTypeNM;
    }

    public void setTopicTypeNM(String topicTypeNM) {
        this.topicTypeNM = topicTypeNM;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getScorepq() {
        return scorepq;
    }

    public void setScorepq(Integer scorepq) {
        this.scorepq = scorepq;
    }

    public Integer getQuestQty() {
        return questQty;
    }

    public void setQuestQty(Integer questQty) {
        this.questQty = questQty;
    }

    public String getkPoints() {
        return kPoints;
    }

    public void setkPoints(String kPoints) {
        this.kPoints = kPoints;
    }

    public Integer getDifficulty1Type() {
        return difficulty1Type;
    }

    public void setDifficulty1Type(Integer difficulty1Type) {
        this.difficulty1Type = difficulty1Type;
    }

    public Integer getDifficulty1Qty() {
        return difficulty1Qty;
    }

    public void setDifficulty1Qty(Integer difficulty1Qty) {
        this.difficulty1Qty = difficulty1Qty;
    }

    public Integer getDifficulty2Type() {
        return difficulty2Type;
    }

    public void setDifficulty2Type(Integer difficulty2Type) {
        this.difficulty2Type = difficulty2Type;
    }

    public Integer getDifficulty2Qty() {
        return difficulty2Qty;
    }

    public void setDifficulty2Qty(Integer difficulty2Qty) {
        this.difficulty2Qty = difficulty2Qty;
    }

    public Integer getDifficulty3Type() {
        return difficulty3Type;
    }

    public void setDifficulty3Type(Integer difficulty3Type) {
        this.difficulty3Type = difficulty3Type;
    }

    public Integer getDifficulty3Qty() {
        return difficulty3Qty;
    }

    public void setDifficulty3Qty(Integer difficulty3Qty) {
        this.difficulty3Qty = difficulty3Qty;
    }

    public List<PaperContent> getPaperContentList() {
        return paperContentList;
    }

    public void setPaperContentList(List<PaperContent> paperContentList) {
        this.paperContentList = paperContentList;
    }
}
