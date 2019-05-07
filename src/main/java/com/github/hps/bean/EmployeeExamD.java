package com.github.hps.bean;

import com.github.hps.util.StringUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 员工考试题目信息
 * Created by whatlookingfor-Jonathan on 16/1/22 11:53.
 */
@Data
public class EmployeeExamD implements Serializable {

    private static final long serialVersionUID = -3322679170136155968L;

    private EmployeeExamPd employeeExamPd;//员工考试试卷信息

    private Long qustkSeq;//大题序号

    private Integer topicTypeId;//  题型ID

    private Long seq;//题目编号

    private Questions questions;//题库信息

    private String title;//大题标题

    private String result;//答案

    private List<String> result1;//多选时页面的答案

    private Integer isRightKey;//是否正确答案

    private Double score;//得分

    public List<String> getResult1() {
        return result1;
    }

    public void setResult1(List<String> result1) {
        this.result1 = result1;
        String mess="";
        for (int i = 0; i < result1.size(); i++) {
            if(StringUtils.isNotBlank(result1.get(i))){
                if(i==result1.size()-1){
                    mess+=result1.get(i);
                }else{
                    mess+=result1.get(i)+";";
                }
            }
        }
        this.result = mess;

    }

    public Integer getTopicTypeId() {
        return topicTypeId;
    }

    public void setTopicTypeId(Integer topicTypeId) {
        this.topicTypeId = topicTypeId;
    }

    public EmployeeExamPd getEmployeeExamPd() {
        return employeeExamPd;
    }

    public void setEmployeeExamPd(EmployeeExamPd employeeExamPd) {
        this.employeeExamPd = employeeExamPd;
    }

    public Long getQustkSeq() {
        return qustkSeq;
    }

    public void setQustkSeq(Long qustkSeq) {
        this.qustkSeq = qustkSeq;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getIsRightKey() {
        return isRightKey;
    }

    public void setIsRightKey(Integer isRightKey) {
        this.isRightKey = isRightKey;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
