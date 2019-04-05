package com.gxy.vbook.controller;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.CartMapper;
import com.gxy.vbook.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping("list")
    public ServerResponse list(@RequestParam("userId") Integer userId){
        return cartService.list(userId);
    }

}
