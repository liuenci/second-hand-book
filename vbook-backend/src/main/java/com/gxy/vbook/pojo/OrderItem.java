package com.gxy.vbook.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;

    private Integer userid;

    private Integer orderno;

    private Integer bookid;

    private String quantity;

    private BigDecimal totalprice;

    public OrderItem(Integer id, Integer userid, Integer orderno, Integer bookid, String quantity, BigDecimal totalprice) {
        this.id = id;
        this.userid = userid;
        this.orderno = orderno;
        this.bookid = bookid;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public OrderItem() {
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

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}