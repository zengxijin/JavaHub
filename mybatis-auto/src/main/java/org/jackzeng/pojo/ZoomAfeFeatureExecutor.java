package org.jackzeng.pojo;

import java.util.Date;

public class ZoomAfeFeatureExecutor {
    private Long id;

    private Long featureExecutorClassId;

    private String inputFieldJsonpath;

    private String outputField;

    private Byte isMust;

    private String dataType;

    private String defaultValue;

    private String variableGroup;

    private String dataSource;

    private String dataInterface;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFeatureExecutorClassId() {
        return featureExecutorClassId;
    }

    public void setFeatureExecutorClassId(Long featureExecutorClassId) {
        this.featureExecutorClassId = featureExecutorClassId;
    }

    public String getInputFieldJsonpath() {
        return inputFieldJsonpath;
    }

    public void setInputFieldJsonpath(String inputFieldJsonpath) {
        this.inputFieldJsonpath = inputFieldJsonpath == null ? null : inputFieldJsonpath.trim();
    }

    public String getOutputField() {
        return outputField;
    }

    public void setOutputField(String outputField) {
        this.outputField = outputField == null ? null : outputField.trim();
    }

    public Byte getIsMust() {
        return isMust;
    }

    public void setIsMust(Byte isMust) {
        this.isMust = isMust;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getVariableGroup() {
        return variableGroup;
    }

    public void setVariableGroup(String variableGroup) {
        this.variableGroup = variableGroup == null ? null : variableGroup.trim();
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getDataInterface() {
        return dataInterface;
    }

    public void setDataInterface(String dataInterface) {
        this.dataInterface = dataInterface == null ? null : dataInterface.trim();
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