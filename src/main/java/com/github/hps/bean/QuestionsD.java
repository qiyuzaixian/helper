package com.github.hps.bean;

import java.io.Serializable;

/**
 * 题库答案选项
 * Created by YangMI on 2015/6/5.
 */
public class QuestionsD implements Serializable {

    private Long questionId;//题目ID

    private String seq;//序号

    private String optionDescr;//选项说明

    private Integer isRightKey;//是否答案


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getOptionDescr() {
        return optionDescr;
    }

    public void setOptionDescr(String optionDescr) {
        optionDescr=optionDescr.trim();
        this.optionDescr = optionDescr;
    }

    public Integer getIsRightKey() {
        return isRightKey;
    }

    public void setIsRightKey(Integer isRightKey) {
        this.isRightKey = isRightKey;
    }

}
