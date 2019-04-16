package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BookService bookService;
    @RequestMapping("add")
    public ServerResponse add(@RequestParam("userId") Integer id, @RequestParam("name") String name, @RequestParam("price") Double price) {
        return bookService.save(id,name,price);
    }
    @GetMapping("list")
    public PageResponse findList(@RequestParam(value = "name",required = false,defaultValue = "") String name) {
        return bookService.findList(name);
    }
    @RequestMapping("l")
    public HashMap<String,Object> list(){
        HashMap<String,Object> map = new HashMap<>();
        User user = new User();
        user.setId(1);
        user.setName("name");
        map.put("total",1);
        List<User> list = new ArrayList<>();
        list.add(user);
        map.put("rows",list);
        return map;
    }
}
