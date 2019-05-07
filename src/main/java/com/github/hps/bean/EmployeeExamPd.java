package com.github.hps.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 员工考试试卷信息实体类
 * Created by whatlookingfor-Jonathan on 16/1/22 11:21.
 */
@Data
public class EmployeeExamPd {

    private EmployeeExam employeeExam;//员工考试信息

    private Papers papers;//卷库信息

    private Long empExamId;//员工考试ID

    private Date sTime;//开始时间

    private Date eTime;//截止时间

    private Double maxScore;//最高分

    private Integer rExTimes;//重考次数

    private Integer examStatus;//考试状态

    private List<EmployeeExamD> detail;//试卷对应的题库信息

    private List<ExamTopicType> examTopicTypeList;//试卷对应的大题信息(大题中包含有题库信息)

}
