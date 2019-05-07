package com.github.hps.bean;

import java.util.Date;

public class HpsMessageInfo {
    private Long id;//主键';
    private String  msgTitle;//消息标题
    private Integer msgMode;//消息发布模式，1正常消息 2.考试
    private String  shortMessage;//短消息，发布模式为文字模式时，该字段启用并写入内容
    private Integer isEnabled;//是否启用
    private Long createUser;//创建人
    private Date creationTime;//创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public Integer getMsgMode() {
        return msgMode;
    }

    public void setMsgMode(Integer msgMode) {
        this.msgMode = msgMode;
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
