package com.gxy.vbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.gxy.vbook.pojo.Comment;

@Mapper
public interface CommentMapper {
    int insert(@Param("comment") Comment comment);

    int insertSelective(@Param("comment") Comment comment);

    int insertList(@Param("comments") List<Comment> comments);

    int updateByPrimaryKeySelective(@Param("comment") Comment comment);
}
