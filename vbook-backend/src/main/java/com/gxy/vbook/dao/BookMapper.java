package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 二手书操作数据库类
 */
@Mapper
public interface BookMapper {
    /**
     * 通过主键删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新纪录
     * @param record
     * @return
     */
    int insert(Book record);

    /**
     * 插入不为空的记录
     * @param record
     * @return
     */
    int insertSelective(Book record);

    /**
     * 通过主键查询记录
     * @param id
     * @return
     */
    Book selectByPrimaryKey(Integer id);

    /**
     * 通过主键更新记录中不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Book record);

    /**
     * 通过主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Book record);

    /**
     * 通过书名查询二手书列表
     * @param name
     * @return
     */
    List<Book> selectListByName(@Param("name") String name);

    /**
     * 管理员
     * @param name
     * @return
     */
    List<Book> selectAllListByName(@Param("name") String name);
    /**
     * 通过二手书ID以及用户ID查询用户
     * @param id
     * @param userId
     * @return
     */
    Book selectByBookIdAndUserId(@Param("id")Integer id, @Param("userId") Integer userId);

    /**
     * 通过用户ID查询二手书列表
     * @param userId
     * @return
     */
    List<Book> selectByUserId(Integer userId);

    List<Book> selectRecommendList();
}