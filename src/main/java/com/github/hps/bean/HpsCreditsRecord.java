package com.github.hps.bean;

import lombok.Data;

import java.util.Date;

@Data
public class HpsCreditsRecord {
    private Long    id;                 //索引
    private Long    creditsRecordId;    //积分记录索引
    private Long    creditsBehaviorId;  //积分行为索引
    private Long    userId;             //用户索引
    private Integer creditsState;       //积分状态（消费积分或添加积分）
    private Date    creditsDt;          //积分时间
    private Integer  creditsType;        //积分行为类型
    private String  creditsContent;     //积分内容
    private Long    creditsRuleId;      //积分规则索引
    private Long    creditsValue;       //积分值
    private Date    createDt;           //创建时间
    private Long    createOper;         //创建者
    private Date    updateDt;           //最后更新时间
    private Long    updateOper;         //最后更新者
    private Integer status;             //状态(索引)
    private Integer delFlag;            //是否删除
    private String  remarks;            //备注
}
