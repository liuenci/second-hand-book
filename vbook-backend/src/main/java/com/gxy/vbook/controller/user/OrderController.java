package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.OrderMapper;
import com.gxy.vbook.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("pay")
    public ServerResponse pay(){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        orderService.pay(userId);
        return ServerResponse.createBySuccess();
    }
    @GetMapping("list")
    public PageResponse list(){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return orderService.list(userId);
    }
}
