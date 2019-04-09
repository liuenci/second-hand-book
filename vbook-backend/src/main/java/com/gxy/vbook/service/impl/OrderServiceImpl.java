package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.*;
import com.gxy.vbook.pojo.Book;
import com.gxy.vbook.pojo.Cart;
import com.gxy.vbook.pojo.Order;
import com.gxy.vbook.pojo.OrderItem;
import com.gxy.vbook.service.OrderService;
import com.gxy.vbook.utils.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ServerResponse pay(int userId) {
        // 获取用户余额
        double balance = userMapper.selectByPrimaryKey(userId).getBalance();
        List<Cart> list = cartMapper.selectListByUserId(userId);
        BigDecimal totalPrice = new BigDecimal("0");
        for (Cart cart : list) {
            Book book = bookMapper.selectByPrimaryKey(cart.getBookid());
            totalPrice = BigDecimalUtil.add(totalPrice.doubleValue(),BigDecimalUtil.mul(book.getPrice(), cart.getQuantity()).doubleValue());
        }
        if (balance < totalPrice.doubleValue()) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.BLANCE_NOT_ENOUGH.getCode(), ResponseCode.BLANCE_NOT_ENOUGH.getDesc());
        }
        Order order = new Order();
        order.setOrderno(UUID.randomUUID().toString());
        order.setCreatetime(new Date());
        for (Cart cart : list) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBookid(cart.getBookid());
            orderItem.setOrderno(order.getOrderno());
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setTotalprice(cart.getQuantity() * bookMapper.selectByPrimaryKey(cart.getBookid()).getPrice());
            orderItemMapper.insert(orderItem);
        }
        // 删除购物车
        cartMapper.deleteByUserId(userId);
        return ServerResponse.createBySuccess();
    }
}
