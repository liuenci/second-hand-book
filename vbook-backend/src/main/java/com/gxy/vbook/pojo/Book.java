package com.gxy.vbook.pojo;

import lombok.*;

import java.util.Date;

/**
 * 二手书类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 书名
     */
    private String name;
    /**
     * 二手书作者
     */
    private String author;
    /**
     * 类型
     */
    private String type;
    /**
     * 原价
     */
    private Double originalPrice;
    /**
     * 新旧率
     */
    private Integer discount;
    /**
     * 折旧后的价格
     */
    private Double price;
    /**
     * 用户ID 标明谁出售的二手书
     */
    private Integer userId;
    /**
     * 图片名称
     */
    private String imgName;
    /**
     * 装帧方式
     */
    private String bindingType;
    /**
     * 出版社
     */
    private String press;
    /**
     * 纸张类型
     */
    private String paperType;
    /**
     * 页数
     */
    private Integer paperNumber;
    /**
     * ISBN
     */
    private String isbn;
    /**
     * 二手书状态 0 卖出 1 在售
     */
    private Integer status;
}