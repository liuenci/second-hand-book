package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private BookService bookService;
    @RequestMapping("add")
    public ServerResponse add(@RequestParam("name") String name, @RequestParam("price") Double price) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return bookService.save(userId,name,price);
    }
    @GetMapping("list")
    public PageResponse findList(@RequestParam(value = "name",required = false,defaultValue = "") String name) {
        return bookService.findList(name);
    }
}
