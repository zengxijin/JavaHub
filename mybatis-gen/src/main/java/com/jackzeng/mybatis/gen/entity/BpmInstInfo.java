package com.jackzeng.mybatis.gen.entity;

import java.util.Date;

public class BpmInstInfo {
    private String transaction_no;

    private Long process_inst_id;

    private String process_status;

    private String created_by;

    private Date created_date;

    private String updated_by;

    private Date updated_date;

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public Long getProcess_inst_id() {
        return process_inst_id;
    }

    public void setProcess_inst_id(Long process_inst_id) {
        this.process_inst_id = process_inst_id;
    }

    public String getProcess_status() {
        return process_status;
    }

    public void setProcess_status(String process_status) {
        this.process_status = process_status;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}