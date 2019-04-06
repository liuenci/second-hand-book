package com.gxy.vbook.controller;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("list")
    public ServerResponse list(@RequestParam("userId") Integer userId) {
        return cartService.list(userId);
    }

    @PostMapping("add")
    public ServerResponse add(HttpSession session, @RequestParam(value = "count", defaultValue = "1", required = false) Integer count, Integer bookId) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse response = cartService.add(bookId, count, userId);
        return ServerResponse.createBySuccess(response);
    }
}
