package com.github.hps.bean;

import lombok.Data;

import java.util.Date;

@Data
public class HpsCreditsType {
    private Long    id;                //索引
    private Long    creditsTypeId;     //积分规则分类ID
    private String  memberId;          //会员ID
    private String  creditsTypeName;   //积分规则分类名称
    private Long    userLevelId;       //用户等级ID
    private String  creditsTypeContent;//积分规则分类说明
    private Date    createDt;          //创建时间
    private Date    updateDt;          //最后更新时间
    private Integer status;            //积分规则分类状态(索引)
    private Integer delFlag;           //积分规则分类是否删除
    private Long    createOper;        //创建者
    private Long    updateOper;        //最后更新者
    private String  remarks;           //备注
    private String  cbId;              //积分行为id
}
