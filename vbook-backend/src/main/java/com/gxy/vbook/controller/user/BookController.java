package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("add")
    public ServerResponse add(@RequestParam("userId") Integer id, @RequestParam("name") String name, @RequestParam("price") Double price) {
        return bookService.save(id,name,price);
    }
    @GetMapping("list")
    public ServerResponse findList(@RequestParam(value = "name",required = false) String name) {
        return bookService.findList(name);
    }
}