package com.github.hps.bean;


import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

/**
 * 考试管理信息 BPM_EXAM
 * Created by mc on 2018/11/7.
 */
public class HelperInfo implements Serializable {

    private static final long serialVersionUID = -2750748485352849013L;
    private Integer rn;//分页编号
    private Long id;   //主键

    private Long parentId;   //用户ID

    private Integer typeId; //信息类别，1.线上课程2.病例分析3.学习路径

    private Long helperType; //产品类别,1.脑心通，2.稳心3....

    private String title;   //信息标题

    private String content;  //发布内容

    private String imageUrl;  //封面图片及介绍图片（同一张图片，如需缩略图再加）

    private String fileUrl;  //资料文件路径

    private String srcOfResource;   //该信息出处（可描述可链接也可以为空）

    private Integer isFile;

    private String text;//图文模式（如果需求内容较大，改为clob,但clob性能较差）

    private Integer status;//状态：1.有效 0.无效

    private Long createUser;//发布者

    private Date releaseDate;//发布日期

    private Long creator;                   //创建人

    private Timestamp creationTime;         //创建时间

    private Long modifier;                  //最后一次更新人

    private Timestamp modifyTime;           //最后一次更新时

    private String creatorNm;

    private String parentNm;

    private Integer praise;//好评次数

    public String getParentNm() {
        return parentNm;
    }

    public void setParentNm(String parentNm) {
        this.parentNm = parentNm;
    }

    public String getCreatorNm() {
        return creatorNm;
    }

    public void setCreatorNm(String creatorNm) {
        this.creatorNm = creatorNm;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getHelperType() {
        return helperType;
    }

    public void setHelperType(Long helperType) {
        this.helperType = helperType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getSrcOfResource() {
        return srcOfResource;
    }

    public void setSrcOfResource(String srcOfResource) {
        this.srcOfResource = srcOfResource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsFile() {
        return isFile;
    }

    public void setIsFile(Integer isFile) {
        this.isFile = isFile;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }
}