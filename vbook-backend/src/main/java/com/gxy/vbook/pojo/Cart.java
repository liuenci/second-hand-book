package com.gxy.vbook.pojo;

public class Cart {
    private Integer id;

    private Integer userid;

    private Integer bookid;

    private String quantity;

    public Cart(Integer id, Integer userid, Integer bookid, String quantity) {
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
        this.quantity = quantity;
    }

    public Cart() {
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
}