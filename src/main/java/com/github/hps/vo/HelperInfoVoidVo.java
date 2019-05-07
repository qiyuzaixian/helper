package com.github.hps.vo;

public class HelperInfoVoidVo{

    private Long   id;  //主键

    private String title;   //信息标题

    private String imageUrl;  //封面图片及介绍图片,视频缩略图

    private String fileUrl;  //资料文件路径

    private String creationTime;         //创建时间

    private Long ReadCount;//观看次数

    private String videoTime;//视频时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Long getReadCount() {
        return ReadCount;
    }

    public void setReadCount(Long readCount) {
        ReadCount = readCount;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }
}