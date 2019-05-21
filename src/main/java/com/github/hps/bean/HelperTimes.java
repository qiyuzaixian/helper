package com.github.hps.bean;


import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

/**
 * 考试管理信息 BPM_EXAM
 * Created by mc on 2018/11/7.
 */
public class HelperTimes implements Serializable {

    private static final long serialVersionUID = -2750748485352849013L;
    private Long orgId;   //部门
    private Long helperId;   //资料ID
    private Long userId; //用户ID
    private Date startDate;//開始時間
    private Date endDate;//結束時間
    private Date billDate;//发布日期
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getHelperId() {
        return helperId;
    }

    public void setHelperId(Long helperId) {
        this.helperId = helperId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
}