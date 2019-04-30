package com.gxy.vbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.gxy.vbook.pojo.Comment;

/**
 * 操作数据库评论的类
 */
@Mapper
public interface CommentMapper {
    /**
     * 插入评论
     * @param comment
     * @return
     */
    int insert(@Param("comment") Comment comment);

    /**
     * 插入记录中不为空的字段
     * @param comment
     * @return
     */
    int insertSelective(@Param("comment") Comment comment);

    /**
     * 插入多个记录
     * @param comments
     * @return
     */
    int insertList(@Param("comments") List<Comment> comments);

    /**
     * 更新记录中不为空的字段
     * @param comment
     * @return
     */
    int updateByPrimaryKeySelective(@Param("comment") Comment comment);
}
