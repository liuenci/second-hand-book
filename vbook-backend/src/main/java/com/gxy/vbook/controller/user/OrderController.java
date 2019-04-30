package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.OrderMapper;
import com.gxy.vbook.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 用户订单接口
 */
@RestController
@RequestMapping("user/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 订单支付
     *
     * @return
     */
    @PostMapping("pay")
    public ServerResponse pay() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        orderService.pay(userId);
        return ServerResponse.createBySuccess();
    }

    /**
     * 获取当前用户所有订单
     *
     * @return
     */
    @GetMapping("list")
    public PageResponse list() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return orderService.list(userId);
    }

    /**
     * 根据订单编号模糊查询订单列表
     * @param orderNo
     * @return
     */
    @GetMapping("{orderNo}")
    public PageResponse orderItemList(@PathVariable("orderNo") String orderNo) {
        return orderService.orderItemList(orderNo);
    }
}
