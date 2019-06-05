package org.jackzeng.pojo;

import java.util.Date;

public class ZoomAfeFeaturesMap {
    private Long id;

    private Integer sceneType;

    private Long featureExecutorId;

    private String sceneNo;

    private String quotaNo;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSceneType() {
        return sceneType;
    }

    public void setSceneType(Integer sceneType) {
        this.sceneType = sceneType;
    }

    public Long getFeatureExecutorId() {
        return featureExecutorId;
    }

    public void setFeatureExecutorId(Long featureExecutorId) {
        this.featureExecutorId = featureExecutorId;
    }

    public String getSceneNo() {
        return sceneNo;
    }

    public void setSceneNo(String sceneNo) {
        this.sceneNo = sceneNo == null ? null : sceneNo.trim();
    }

    public String getQuotaNo() {
        return quotaNo;
    }

    public void setQuotaNo(String quotaNo) {
        this.quotaNo = quotaNo == null ? null : quotaNo.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}