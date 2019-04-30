package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作数据库用户类
 */
@Mapper
public interface UserMapper {
    /**
     * 通过主键ID删除某个用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一个新用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 插入用户类中不为空的字段
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 通过主键查询特定用户
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 通过主键ID更新用户记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 通过主键ID更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过用户名查询用户
     * @param name
     * @return
     */
    User selectByName(String name);

    /**
     * 通过用户名以及密码查询用户是否存在
     * @param name
     * @param password
     * @return
     */
    User selectByNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     * 查询用户列表
     * @param name
     * @return
     */
    List<User> selectUserList(String name);

    /**
     * 通过推荐级别倒序查询所有用户
     * @return
     */
    List<User> selectListOrderByLevel();
}