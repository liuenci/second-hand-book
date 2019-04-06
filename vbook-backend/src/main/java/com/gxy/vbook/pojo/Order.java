package com.gxy.vbook.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private String orderno;

    private Date createtime;

    public Order(Integer id, String orderno, Date createtime) {
        this.id = id;
        this.orderno = orderno;
        this.createtime = createtime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}