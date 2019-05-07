package com.github.hps.bean;

import lombok.Data;

import java.util.Date;
@Data
public class ExamRank {
    private String  employeeNm;
    private Long    orgId;
    private Long    employeeId;
    private Double  maxScore;
    private Integer sex;
    private Long    userId;
    private Date modifyTime;
    private String phonePath;
    private String orgNm;
    private String roleName;
    private Integer rank;

}
