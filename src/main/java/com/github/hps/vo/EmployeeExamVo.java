package com.github.hps.vo;

import com.github.hps.bean.BPMExam;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 员工考试信息返回类
 * Created by mc on 2019/1/21.
 */
public class EmployeeExamVo implements Serializable{

    private static final long serialVersionUID = -7304867173398674591L;

    private Long employeeId;//员工ID

    private BPMExam exam;//考试管理信息

    private Integer stageSeq;//关数

    private Timestamp sTime;//开始时间

    private Timestamp eTime;//截止时间

    private Integer examStatus;//考试状态

    private Double maxScore;//最高分

    private Double score;//本次考试得分

    private String examRkndCd;//考试结果分类编码

    private Integer examRknd;//考试结果

    private Integer isEnabled;//是否有效

    private Integer isTure;//页面控制是否重考

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public BPMExam getExam() {
        return exam;
    }

    public void setExam(BPMExam exam) {
        this.exam = exam;
    }

    public Integer getStageSeq() {
        return stageSeq;
    }

    public void setStageSeq(Integer stageSeq) {
        this.stageSeq = stageSeq;
    }

    public Timestamp getsTime() {
        return sTime;
    }

    public void setsTime(Timestamp sTime) {
        this.sTime = sTime;
    }

    public Timestamp geteTime() {
        return eTime;
    }

    public void seteTime(Timestamp eTime) {
        this.eTime = eTime;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public String getExamRkndCd() {
        return examRkndCd;
    }

    public void setExamRkndCd(String examRkndCd) {
        this.examRkndCd = examRkndCd;
    }

    public Integer getExamRknd() {
        return examRknd;
    }

    public void setExamRknd(Integer examRknd) {
        this.examRknd = examRknd;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getIsTure() {
        return isTure;
    }

    public void setIsTure(Integer isTure) {
        this.isTure = isTure;
    }

}