package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库订单子表类
 */
@Mapper
public interface OrderItemMapper {
    /**
     * 通过主键ID删除订单字表
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新的订单子表
     * @param record
     * @return
     */
    int insert(OrderItem record);

    /**
     * 插入订单子表中不为空的字段
     * @param record
     * @return
     */
    int insertSelective(OrderItem record);

    /**
     * 通过主键ID查询具体的订单子表记录
     * @param id
     * @return
     */
    OrderItem selectByPrimaryKey(Integer id);

    /**
     * 通过主键更新订单子表记录中不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderItem record);

    /**
     * 通过主键ID更新订单子表记录中所有字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrderItem record);

    /**
     * 通过订单号查询所有订单的子表记录
     * @param orderNo
     * @return
     */
    List<OrderItem> selectByOrderNo(String orderNo);
}