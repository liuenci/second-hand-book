package com.gxy.vbook.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * 订单子表展示类
 */
public class OrderItemVo {
    /**
     * 二手书ID
     */
    private Integer bookId;
    /**
     * 二手书名
     */
    private String bookName;
    /**
     * 价格
     */
    private Double price;
    /**
     * 数量
     */
    private Integer quantity;
}
