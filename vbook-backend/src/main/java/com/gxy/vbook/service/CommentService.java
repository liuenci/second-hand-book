package com.gxy.vbook.service;

import java.util.List;
import com.gxy.vbook.pojo.Comment;
public interface CommentService{

    int insert(Comment comment);

    int insertSelective(Comment comment);

    int insertList(List<Comment> comments);

    int updateByPrimaryKeySelective(Comment comment);
}
