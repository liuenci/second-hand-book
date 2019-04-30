package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库订单类
 */
@Mapper
public interface OrderMapper {
    /**
     * 通过主键ID删除订单记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新纪录
     * @param record
     * @return
     */
    int insert(Order record);

    /**
     * 插入订单记录中不为空的记录
     * @param record
     * @return
     */
    int insertSelective(Order record);

    /**
     * 通过主键ID查询订单
     * @param id
     * @return
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 通过主键ID更新订单中不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 通过主键ID更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Order record);

    /**
     * 通过用户ID查询特定用户的所有订单
     * @param userId
     * @return
     */
    List<Order> selectListByUserId(Integer userId);

    /**
     * 通过订单编号模糊查询订单记录
     * @param orderNo
     * @return
     */
    List<Order> selectOrderList(String orderNo);
}