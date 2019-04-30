package com.gxy.vbook.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 评论类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 评论内容
     */
    private String comment;
}
