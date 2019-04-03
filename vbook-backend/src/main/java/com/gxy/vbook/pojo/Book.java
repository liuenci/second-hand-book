package com.gxy.vbook.pojo;

import java.math.BigDecimal;

public class Book {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer userid;

    private Byte status;

    public Book(Integer id, String name, BigDecimal price, Integer userid, Byte status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.userid = userid;
        this.status = status;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}