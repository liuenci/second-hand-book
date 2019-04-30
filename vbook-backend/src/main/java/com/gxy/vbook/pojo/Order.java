package com.gxy.vbook.pojo;

import lombok.*;

import java.util.Date;

/**
 * 订单类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID 标明是哪个用户的订单
     */
    private Integer userId;

    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 创建时间
     */
    private Date createTime;
}