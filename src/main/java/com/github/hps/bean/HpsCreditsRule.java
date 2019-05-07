package com.github.hps.bean;

import lombok.Data;

import java.util.Date;

@Data
public class HpsCreditsRule {
    private Long    id;                 //索引
    private Long    creditsRuleId;      //积分规则索引
    private Long    memberId;           //会员索引
    private Long    creditsTypeId;      //积分规则分类索引
    private String  creditsRuleContent; //积分规则内容
    private Long    creditsActionId;    //积分动作编号索引
    private Double    maxValue;           //最大值
    private Double    minValue;           //最小值
    private Long    creditsValue;       //积分值
    private Integer isRepeat;           //是否每天一次性
    private Integer creditsUpperValue;  //每天积分上限值（0-不限制）
    private Date    startCreditsDt;     //生效时间
    private Date    endCreditsDt;       //结束时间
    private Date    createDt;           //创建时间
    private Date    updateDt;           //最后更新时间
    private Long    createOper;         //创建者
    private Long    updateOper;         //最后更新者
    private Integer status;             //积分规则状态(索引)
    private Integer delFlag;            //积分规则是否删除
    private String  remarks;            //备注
    private Integer modelType;          //代表模板（0 管理员可见  1 普通用户可见）

}
