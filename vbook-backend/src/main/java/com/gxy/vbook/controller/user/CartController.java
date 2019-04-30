package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.service.CartService;
import com.gxy.vbook.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取当前登录用户的购物车列表
     * @return
     */
    @RequestMapping("list")
    public PageResponse list() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return cartService.list(userId);
    }

    /**
     * 添加二手书到购物车
     * @param count
     * @param bookId
     * @return
     */
    @PostMapping("add")
    public ServerResponse add(@RequestParam(value = "count", defaultValue = "1", required = false) Integer count, Integer bookId) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse response = cartService.add(bookId, count, userId);
        return ServerResponse.createBySuccess(response);
    }

    /**
     * 计算购物车中的总价
     * @return
     */
    @GetMapping("totalPrice")
    public ServerResponse totalPrice(){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        PageResponse response = cartService.list(userId);
        List<CartVo> list = response.getRows();
        Double totalPrice = 0D;
        for (CartVo cartVo : list) {
            Double price = cartVo.getPrice();
            Integer quantity = cartVo.getQuantity();
            totalPrice += price * quantity;
        }
        return ServerResponse.createBySuccess(totalPrice);
    }
}
