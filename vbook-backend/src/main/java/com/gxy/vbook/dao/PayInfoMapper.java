package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.PayInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作数据库支付信息类
 */
@Mapper
public interface PayInfoMapper {
    /**
     * 通过主键ID删除支付信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新的支付信息
     * @param record
     * @return
     */
    int insert(PayInfo record);

    /**
     * 插入支付信息中不为空的字段
     * @param record
     * @return
     */
    int insertSelective(PayInfo record);

    /**
     * 通过主键查询具体的支付信息
     * @param id
     * @return
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * 通过主键ID更新记录中不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     * 通过主键ID更新记录中所有字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(PayInfo record);
}