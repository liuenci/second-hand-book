package com.gxy.vbook.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.vbook.pojo.Comment;
import com.gxy.vbook.dao.CommentMapper;
import com.gxy.vbook.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int insert(Comment comment){
        return commentMapper.insert(comment);
    }

    @Override
    public int insertSelective(Comment comment){
        return commentMapper.insertSelective(comment);
    }

    @Override
    public int insertList(List<Comment> comments){
        return commentMapper.insertList(comments);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment comment){
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
