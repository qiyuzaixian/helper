package com.github.hps.bean;

import lombok.Data;


import java.util.Date;

@Data
public class HpsCreditsBehavior {
    private Integer id;                 //索引
    private Long  behaviorId;           //积分行为索引
    private String  behaviorName;       //积分行为名称
    private Long  parentId;             //父积分行为索引
    private Integer isShow;             //是否显示
    private String  behaviorRemarks;    //积分行为备注
    private Date    createDt;           //创建时间
    private Long  createOper;           //创建者
    private Date    updateDt;           //最后更新时间
    private Long  updateOper;           //最后更新者
    private Integer status;             //状态
    private Integer delFlag;            //是否删除
    private String  remarks;            //备注
}
