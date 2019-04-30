package com.gxy.vbook.service;

import com.gxy.vbook.pojo.Comment;

/**
 * 评论接口
 */
public interface CommentService{
    /**
     * 插入新评论
     * @param comment
     * @return
     */
    int insert(Comment comment);
}
