package com.beyondli.dto;

import java.time.LocalDateTime;

public class SysScheduleJob {
    private String id;
    private String job_name;
    private String cron_expression;
    private String bean_name;
    private String method_name;
    private Integer status;
    private String user_id;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private Integer del_flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getCron_expression() {
        return cron_expression;
    }

    public void setCron_expression(String cron_expression) {
        this.cron_expression = cron_expression;
    }

    public String getBean_name() {
        return bean_name;
    }

    public void setBean_name(String bean_name) {
        this.bean_name = bean_name;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "SysScheduleJob{" +
                "id=" + id +
                ", job_name='" + job_name + '\'' +
                ", cron_expression='" + cron_expression + '\'' +
                ", bean_name='" + bean_name + '\'' +
                ", method_name='" + method_name + '\'' +
                ", status=" + status +
                ", user_id='" + user_id + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", del_flag=" + del_flag +
                '}';
    }
}
