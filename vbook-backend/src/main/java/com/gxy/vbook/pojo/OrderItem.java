package com.gxy.vbook.pojo;

import lombok.*;

import java.math.BigDecimal;

/**
 * 订单子表类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID 标明是哪个用户出售的二手书
     */
    private Integer userId;
    /**
     * 订单编号 标明是哪个订单
     */
    private String orderNo;
    /**
     * 二手书ID
     */
    private Integer bookId;
    /**
     * 二手书数量
     */
    private Integer quantity;
    /**
     * 总价
     */
    private Double totalPrice;
}