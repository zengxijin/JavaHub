package com.jackzeng.mybatis.gen.entity;

import java.util.Date;

public class TenantSchemaCfg {
    private Long id;

    private String tenant_id;

    private String tenant_schema;

    private String db_type;

    private Date created_date;

    private String created_by;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTenant_schema() {
        return tenant_schema;
    }

    public void setTenant_schema(String tenant_schema) {
        this.tenant_schema = tenant_schema;
    }

    public String getDb_type() {
        return db_type;
    }

    public void setDb_type(String db_type) {
        this.db_type = db_type;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}