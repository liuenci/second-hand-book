package com.gxy.vbook.vo;

import lombok.Data;

@Data
public class BookRecordVo {
    /**
     * 二手书主键ID
     */
    private Integer bookId;
    /**
     * 发布二手书的用户ID
     */
    private Integer userId;
    /**
     * 买家ID
     */
    private Integer buyerUserId;
    /**
     * 买家name
     */
    private String buyerUserName;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 封面图
     */
    private String imgName;
    /**
     * 售价
     */
    private Double price;
    /**
     * 状态
     */
    private String status;
}
