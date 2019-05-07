package com.github.hps.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 考试管理  卷库试卷内容信息  TRN_PAPERCONTENT
 * Created by LZY on 2016/1/26.
 */
public class PaperContent implements Serializable {


    private static final long serialVersionUID = 7502408696590877686L;

    private Long paperId;   //试卷ID
    private Long qustkSeq; //大题序号
    private Long questionId;//题目ID
    private Integer seq;    //题目编号
    private Integer score;  //分数

    private List<QuestionsD> questionsDList;

    private Questions questions;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getQustkSeq() {
        return qustkSeq;
    }

    public void setQustkSeq(Long qustkSeq) {
        this.qustkSeq = qustkSeq;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<QuestionsD> getQuestionsDList() {
        return questionsDList;
    }

    public void setQuestionsDList(List<QuestionsD> questionsDList) {
        this.questionsDList = questionsDList;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
