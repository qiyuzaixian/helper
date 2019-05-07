package com.github.hps.bean;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * 考试试卷中的题型管理实体类
 * 未用题型管理的实体类，因为卷库中的大标题与题型的标题可以不一致，而且实体类的关联太多，所以单独建立实体类
 * 实体类主要用于试卷的预览，考试，考试结果评价
 * Created by whatlookingfor-Jonathan on 16/1/22 16:08.
 */
public class ExamTopicType implements Serializable {


    private static final long serialVersionUID = 8009503721829209594L;

    private String title;//题型名称

    private Long qustkSeq;//大题序号

    private Integer topicTypeId;//  题型ID

    private List<EmployeeExamD> examDList = Lists.newArrayList();//用于考试

    private List<Questions> questionsList = Lists.newArrayList();//计划用于考试信息管理中的试卷预览，考试中无用，可以修改


    public Long getQustkSeq() {
        return qustkSeq;
    }

    public void setQustkSeq(Long qustkSeq) {
        this.qustkSeq = qustkSeq;
    }

    public Integer getTopicTypeId() {
        return topicTypeId;
    }

    public void setTopicTypeId(Integer topicTypeId) {
        this.topicTypeId = topicTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<EmployeeExamD> getExamDList() {
        return examDList;
    }

    public void setExamDList(List<EmployeeExamD> examDList) {
        this.examDList = examDList;
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }
}
