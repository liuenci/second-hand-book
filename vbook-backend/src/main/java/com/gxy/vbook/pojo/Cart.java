package com.gxy.vbook.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 购物车类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID 标明是哪个用户的购物车
     */
    private Integer userId;
    /**
     * 二手书ID 标明是哪本书
     */
    private Integer bookId;
    /**
     * 出售数量
     */
    private Integer quantity;

}