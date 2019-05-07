package com.github.hps.bean;


import java.io.Serializable;
import java.util.Date;
public class BPMExamCount implements Serializable{
	private static final long serialVersionUID = 1389959594229878881L;

	private Long id;

	private Long examId;
	private String title;
	private Integer stageSeq;
	private Integer isEnabled;// number(1),'是否有效';
	private Long creator;// number(6),'起草人';
	private Date creationTime;// date,'起草时间';
	private Long modifier;// number(6),'最后一次更新人';
	private Date modifyTime;// date,'最后一次更新时间';

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

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Integer getStageSeq() {
		return stageSeq;
	}

	public void setStageSeq(Integer stageSeq) {
		this.stageSeq = stageSeq;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Long getModifier() {
		return modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
