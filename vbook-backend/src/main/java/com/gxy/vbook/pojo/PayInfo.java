package com.gxy.vbook.pojo;

import java.util.Date;

public class PayInfo {
    private Integer id;

    private Integer userid;

    private Integer orderno;

    private Integer status;

    private Date time;

    public PayInfo(Integer id, Integer userid, Integer orderno, Integer status, Date time) {
        this.id = id;
        this.userid = userid;
        this.orderno = orderno;
        this.status = status;
        this.time = time;
    }

    public PayInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}