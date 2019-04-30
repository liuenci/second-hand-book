package com.gxy.vbook.pojo;

import lombok.*;

import java.util.Date;

/**
 * 捐赠二手书类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonateBook {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID 标明是哪个用户捐赠的
     */
    private Integer userId;
    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
    /**
     * 原价
     */
    private Double originalPrice;
    /**
     * 新旧率
     */
    private Integer discount;
    /**
     * 捐赠时间
     */
    private Date createTime;
}
