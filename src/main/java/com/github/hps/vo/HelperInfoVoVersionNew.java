package com.github.hps.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class HelperInfoVoVersionNew implements Serializable {

    private static final long serialVersionUID = -2750748485352849013L;

    private Long   id;  //主键

    private String title;   //信息标题

    private String imageUrl;  //封面图片及介绍图片（同一张图片，如需缩略图再加）

    private String fileUrl;  //资料文件路径

    private Integer isFile;

    private String creationTime;         //创建时间

    private Long ReadCount;//观看次数

    private Long praise;//好评次数
}