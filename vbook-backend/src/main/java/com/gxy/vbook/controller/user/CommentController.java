package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.Comment;
import com.gxy.vbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论接口
 */
@RequestMapping("comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加新的评论
     * @param comment
     * @return
     */
    @RequestMapping("add")
    public ServerResponse addComment(@RequestBody Comment comment){
        int insert = commentService.insert(comment);
        return ServerResponse.createBySuccess();
    }
}
