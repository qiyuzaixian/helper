package com.github.hps.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 考试管理信息 BPM_EXAM
 * Created by mc on 2018/11/7.
 */
public class BPMExam implements Serializable {

    private static final long serialVersionUID = 7502408696590877686L;
    private Integer rn;//分页编号

    private Long examId;//               number(12)           not null, '考试ID';
    private String title;//                varchar2(64)         not null,'标题';
    private Date billDate;//             date,'日期';
    private Long billNo;//               number(12),'培训ID';
    private Integer isTrain;//              number(1),'是否培训（1：是  0：否)';
    private String examKindCd;//           char(8),'考试分类编码';
    private Integer examKind;//             number(3),'考试分类(1: 入司级别 2: 日常级别 3: 专业级别 4:大区PK)';
    private String examKindNm;//            考试分类名称
    private String prpostkdCd;//           char(8),'组卷方式编码';
    private Integer prpostkd;//             number(3),'组卷方式(1:卷库抽卷  2：题库抽题   3:自主命题组卷)
    private Integer excpsetQty;//           number(3),'组卷套数';
    private Integer isAllowRepeat;//        number(1),'是否允许重复考试(1: 是  0：否)';
    private Integer isSetKPoint;//          number(1),'是否设置知识点(是否需要考试为1是有效)';
    private Integer isEvaResult;//          number(1),'是否评价结果(1：是 0：否)';
    private Integer isPstage;//             number(1),'是否闯关';
    private Integer totStages;//            number(2),'总关数';
    private Integer totalScore;//           number(3),'总分数';
    private Integer passsCore;//            number(3),'通过分数';
    private Timestamp eSTime;//               date,'考试开始时间';
    private Timestamp eETime;//               date,'考试结束时间';
    private Integer  duration;//             number(3),'时长(分钟)';
    private Long plnQty;//               number(10),'预计参与人数';
    private Long actQty;//               number(10),'实际参与人数';
    private Integer examStatus;//           number(1),'考试状态(0:未开考 1：考试进行中 9：考试完成)';
    private Integer isFinishOrg;//          number(1),'参考部门是否设置完成(1:是  0:否)';
    private Integer isFinishQt;//           number(1),'题型是否设置完成(1:是 0:否)
    private Integer isFinishQp;//           number(1),'组卷是否完成(1:是 0:否)
    private Integer isFinishSe;//           number(1),'结果评价是否完成';
    private String remark;//               varchar2(512),'备注';
    private Integer billStatus;//           number(3),'任务状态';
    private Integer isEnabled;//            number(1),'是否有效';
    private Long creator;//              number(6),'起草人';
    private Long orgId;//                number(6),'起草人部门';
    private Date creationTime ;//        date,'起草时间';
    private Long modifier;//             number(6),'最后一次更新人';
    private Date modifyTime;//           date,'最后一次更新时间';
    private String actId;//                varchar2(64),'流程实例ID';
    private String actModelKey;//          varchar2(64),'流程模型ID(对应ACT_RE_MODEL.KEY_字段)';

    private Integer examIng;//正在考试人数

    //起草人姓名
    private String employeeNm;
    private String orgNm;

    //考试管理信息列表查询条件
    private Long pOrgId;//组织部门ID
    private String pOrgNm;//组织部门名称
    private Long cOrgId; //参考部门ID
    private String cOrgNm;//参考部门名称
    private Long roleId;//参考岗位
    private Integer flag;//同意、驳回


    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Long getBillNo() {
        return billNo;
    }

    public void setBillNo(Long billNo) {
        this.billNo = billNo;
    }

    public Integer getIsTrain() {
        return isTrain;
    }

    public void setIsTrain(Integer isTrain) {
        this.isTrain = isTrain;
    }

    public String getExamKindCd() {
        return examKindCd;
    }

    public void setExamKindCd(String examKindCd) {
        this.examKindCd = examKindCd;
    }

    public Integer getExamKind() {
        return examKind;
    }

    public void setExamKind(Integer examKind) {
        this.examKind = examKind;
    }

    public String getPrpostkdCd() {
        return prpostkdCd;
    }

    public void setPrpostkdCd(String prpostkdCd) {
        this.prpostkdCd = prpostkdCd;
    }

    public Integer getPrpostkd() {
        return prpostkd;
    }

    public void setPrpostkd(Integer prpostkd) {
        this.prpostkd = prpostkd;
    }

    public Integer getExcpsetQty() {
        return excpsetQty;
    }

    public void setExcpsetQty(Integer excpsetQty) {
        this.excpsetQty = excpsetQty;
    }

    public Integer getIsAllowRepeat() {
        return isAllowRepeat;
    }

    public void setIsAllowRepeat(Integer isAllowRepeat) {
        this.isAllowRepeat = isAllowRepeat;
    }

    public Integer getIsSetKPoint() {
        return isSetKPoint;
    }

    public void setIsSetKPoint(Integer isSetKPoint) {
        this.isSetKPoint = isSetKPoint;
    }

    public Integer getIsEvaResult() {
        return isEvaResult;
    }

    public void setIsEvaResult(Integer isEvaResult) {
        this.isEvaResult = isEvaResult;
    }

    public Integer getIsPstage() {
        return isPstage;
    }

    public void setIsPstage(Integer isPstage) {
        this.isPstage = isPstage;
    }

    public Integer getTotStages() {
        return totStages;
    }

    public void setTotStages(Integer totStages) {
        this.totStages = totStages;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getPasssCore() {
        return passsCore;
    }

    public void setPasssCore(Integer passsCore) {
        this.passsCore = passsCore;
    }

    public Timestamp geteSTime() {
        return eSTime;
    }

    public void seteSTime(Timestamp eSTime) {
        this.eSTime = eSTime;
    }

    public Timestamp geteETime() {
        return eETime;
    }

    public void seteETime(Timestamp eETime) {
        this.eETime = eETime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getPlnQty() {
        return plnQty;
    }

    public void setPlnQty(Long plnQty) {
        this.plnQty = plnQty;
    }

    public Long getActQty() {
        return actQty;
    }

    public void setActQty(Long actQty) {
        this.actQty = actQty;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public Integer getIsFinishOrg() {
        return isFinishOrg;
    }

    public void setIsFinishOrg(Integer isFinishOrg) {
        this.isFinishOrg = isFinishOrg;
    }

    public Integer getIsFinishQt() {
        return isFinishQt;
    }

    public void setIsFinishQt(Integer isFinishQt) {
        this.isFinishQt = isFinishQt;
    }

    public Integer getIsFinishQp() {
        return isFinishQp;
    }

    public void setIsFinishQp(Integer isFinishQp) {
        this.isFinishQp = isFinishQp;
    }

    public Integer getIsFinishSe() {
        return isFinishSe;
    }

    public void setIsFinishSe(Integer isFinishSe) {
        this.isFinishSe = isFinishSe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getActModelKey() {
        return actModelKey;
    }

    public void setActModelKey(String actModelKey) {
        this.actModelKey = actModelKey;
    }

    public String getEmployeeNm() {
        return employeeNm;
    }

    public void setEmployeeNm(String employeeNm) {
        this.employeeNm = employeeNm;
    }

    public String getOrgNm() {
        return orgNm;
    }

    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }


    public Long getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(Long pOrgId) {
        this.pOrgId = pOrgId;
    }

    public String getpOrgNm() {
        return pOrgNm;
    }

    public void setpOrgNm(String pOrgNm) {
        this.pOrgNm = pOrgNm;
    }

    public Long getcOrgId() {
        return cOrgId;
    }

    public void setcOrgId(Long cOrgId) {
        this.cOrgId = cOrgId;
    }

    public String getcOrgNm() {
        return cOrgNm;
    }

    public void setcOrgNm(String cOrgNm) {
        this.cOrgNm = cOrgNm;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getExamKindNm() {
        return examKindNm;
    }

    public void setExamKindNm(String examKindNm) {
        this.examKindNm = examKindNm;
    }

    public void setExamIng(Integer examIng) {
        this.examIng = examIng;
    }
    public Integer getExamIng() {
        return examIng;
    }

}