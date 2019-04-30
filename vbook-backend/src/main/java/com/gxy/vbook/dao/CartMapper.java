package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 购物车操作数据库类
 */
@Mapper
public interface CartMapper {
    /**
     * 通过主键ID删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新记录
     * @param record
     * @return
     */
    int insert(Cart record);

    /**
     * 插入记录中不为空的字段
     * @param record
     * @return
     */
    int insertSelective(Cart record);

    /**
     * 通过主键ID查询购物车
     * @param id
     * @return
     */
    Cart selectByPrimaryKey(Integer id);

    /**
     * 更新记录中不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * 通过主键ID更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Cart record);

    /**
     * 通过用户ID查询购物车列表
     * @param userId
     * @return
     */
    List<Cart> selectListByUserId(Integer userId);

    /**
     * 通过用户ID删除购物车
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
}