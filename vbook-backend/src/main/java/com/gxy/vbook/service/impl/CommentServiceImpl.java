package com.gxy.vbook.service.impl;

import com.gxy.vbook.dao.OrderItemMapper;
import com.gxy.vbook.dao.OrderMapper;
import com.gxy.vbook.dao.UserMapper;
import com.gxy.vbook.pojo.OrderItem;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.utils.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 插入新的评论
     * @param comment
     * @return
     */
    @Override
    public int insert(Comment comment){
        Integer score = comment.getScore();
        String orderNo = comment.getOrderNo();
        List<OrderItem> orderItems = orderItemMapper.selectByOrderNo(orderNo);
        for (OrderItem orderItem : orderItems) {
            Integer userId = orderItem.getUserId();
            User user = userMapper.selectByPrimaryKey(userId);
            int totalScore = user.getTotalScore() == null ? 0 : user.getTotalScore();
            user.setTotalScore(totalScore + score);
            int commentNumber = user.getCommentNumber() == null ? 0 : user.getCommentNumber();
            user.setCommentNumber(commentNumber + 1);
            user.setLevel(BigDecimalUtil.div(user.getTotalScore().doubleValue(),user.getCommentNumber().doubleValue()).doubleValue());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return commentMapper.insert(comment);
    }
}
