package com.gxy.vbook.controller.admin;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台二手书接口
 */
@RestController
@RequestMapping("admin/book")
public class AdminBookController {
    @Autowired
    private BookService bookService;

    /**
     * 查看所有二手书
     * @param name
     * @return
     */
    @RequestMapping("list")
    public PageResponse list(@RequestParam("name")String name){
        return bookService.findList(name);
    }
}
