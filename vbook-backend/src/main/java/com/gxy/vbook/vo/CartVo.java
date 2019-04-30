package com.gxy.vbook.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * 购物车展示类
 */
public class CartVo {
    /**
     * 二手书ID
     */
    private Integer bookId;
    /**
     * 书名
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 数量
     */
    private Integer quantity;
}
