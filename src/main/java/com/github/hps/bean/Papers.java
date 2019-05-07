package com.github.hps.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 卷库信息的实体类
 * Created by whatlookingfor-Jonathan on 16/1/22 11:31.
 */
public class Papers implements Serializable {

    private static final long serialVersionUID = -9126690098587628916L;

    private Long paperId;//试卷ID

    private BPMExam exam;//考试信息实体类

    private String title;//试卷标题

    private String prPostKdCd;//组卷方式编码

    private Integer prPostKd;//组卷方式

    private Integer isSetKpoint;//是否设置知识点

    private Integer totalScore;//总分数

    private Integer passScore;//通过分数

    private Integer useTimes;//使用次数

    private Integer isInPapers;//是否放到卷宗

    private Integer stageSeq;//第几关

    private Integer isEnabled;//是否有效
    private Long creator;//创建人
    private Timestamp creationTime;//创建时间
    private Long modifier;//修改人
    private Timestamp modifyTime;//修改时间

    private List<PaperQustKD> paperQustKDList;//试卷题型信息

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public BPMExam getExam() {
        return exam;
    }

    public void setExam(BPMExam exam) {
        this.exam = exam;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrPostKdCd() {
        return prPostKdCd;
    }

    public void setPrPostKdCd(String prPostKdCd) {
        this.prPostKdCd = prPostKdCd;
    }

    public Integer getPrPostKd() {
        return prPostKd;
    }

    public void setPrPostKd(Integer prPostKd) {
        this.prPostKd = prPostKd;
    }

    public Integer getIsSetKpoint() {
        return isSetKpoint;
    }

    public void setIsSetKpoint(Integer isSetKpoint) {
        this.isSetKpoint = isSetKpoint;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
    }

    public Integer getIsInPapers() {
        return isInPapers;
    }

    public void setIsInPapers(Integer isInPapers) {
        this.isInPapers = isInPapers;
    }

    public Integer getStageSeq() {
        return stageSeq;
    }

    public void setStageSeq(Integer stageSeq) {
        this.stageSeq = stageSeq;
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

    public List<PaperQustKD> getPaperQustKDList() {
        return paperQustKDList;
    }

    public void setPaperQustKDList(List<PaperQustKD> paperQustKDList) {
        this.paperQustKDList = paperQustKDList;
    }
}
