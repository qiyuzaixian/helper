package com.github.hps.vo;

import java.util.Date;

public class HpsMessageInfoVo {
    private Long id;//主键;
    private String  msgTitle;//消息标题
    private String  shortMessage;//短消息，发布模式为文字模式时，该字段启用并写入内容
    private String creationTime;//创建时间

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

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
