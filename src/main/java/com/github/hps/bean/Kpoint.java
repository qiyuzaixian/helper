package com.github.hps.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 知识点信息
 * Created by chengyingmo on 2015/5/29.
 */
@Data
public class Kpoint implements Serializable {

    private Long kpointId;//知识点ID
    private String kpointNm;//知识点名称
    private Kpoint parent;//父节点信息
    private Long pumPingTimes;//抽中次数
    private Integer isEnabled;//是否有效
    private Long creator;//创建人
    private Timestamp creationTime;//创建时间
    private Long modifier;//修改人
    private Timestamp modifyTime;//修改时间
}
