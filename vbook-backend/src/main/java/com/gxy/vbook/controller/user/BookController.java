package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.Book;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private BookService bookService;
    @RequestMapping("add")
    public ServerResponse add(@RequestBody Book book) {
        return bookService.save(book);
    }
    @GetMapping("list")
    public PageResponse findList(@RequestParam(value = "name",required = false,defaultValue = "") String name) {
        return bookService.findList(name);
    }
    @RequestMapping("isMine")
    public ServerResponse isMine(@RequestParam("id") Integer id){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return bookService.isMine(id,userId);
    }
    @GetMapping("recommended")
    public PageResponse recommendedList() {
        return bookService.recommendedList();
    }

}
