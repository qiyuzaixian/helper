package com.github.hps.vo;

import lombok.Data;

import java.util.Date;

@Data
public class HpsCreditsRecordVo {
    private String  createDt;          //积分时间
    private String  creditsContent;     //积分内容
    private Long    creditsValue;       //积分值

}
