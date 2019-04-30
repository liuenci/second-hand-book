package com.gxy.vbook.pojo;

import lombok.Data;


import java.util.Date;

@Data
public class PayInfo {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID 标明是哪个用户的支付信息
     */
    private Integer userId;

    /**
     * 订单编号 标明是为哪个订单支付的
     */
    private Integer orderNo;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 支付时间
     */
    private Date time;
}