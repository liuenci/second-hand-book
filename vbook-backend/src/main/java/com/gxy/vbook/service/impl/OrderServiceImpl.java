package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.*;
import com.gxy.vbook.pojo.*;
import com.gxy.vbook.service.OrderService;
import com.gxy.vbook.utils.BigDecimalUtil;
import com.gxy.vbook.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponse pay(int userId) {
        // 获取用户余额
        double balance = userMapper.selectByPrimaryKey(userId).getBalance();
        List<Cart> list = cartMapper.selectListByUserId(userId);
        BigDecimal totalPrice = new BigDecimal("0");
        for (Cart cart : list) {
            Book book = bookMapper.selectByPrimaryKey(cart.getBookid());
            totalPrice = BigDecimalUtil.add(totalPrice.doubleValue(), BigDecimalUtil.mul(book.getPrice(), cart.getQuantity()).doubleValue());
        }
        if (balance < totalPrice.doubleValue()) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.BLANCE_NOT_ENOUGH.getCode(), ResponseCode.BLANCE_NOT_ENOUGH.getDesc());
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(totalPrice.doubleValue());
        order.setOrderno(UUID.randomUUID().toString());
        order.setCreatetime(new Date());
        // 插入订单主表
        orderMapper.insert(order);
        for (Cart cart : list) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBookid(cart.getBookid());
            orderItem.setOrderno(order.getOrderno());
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setTotalprice(cart.getQuantity() * bookMapper.selectByPrimaryKey(cart.getBookid()).getPrice());
            orderItem.setUserid(userId);
            orderItemMapper.insert(orderItem);

            // 更新二手书的状态
            Book book = new Book();
            book.setId(cart.getBookid());
            book.setStatus(0);
            bookMapper.updateByPrimaryKeySelective(book);
        }
        // 删除购物车
        cartMapper.deleteByUserId(userId);
        return ServerResponse.createBySuccess();
    }

    @Override
    public PageResponse list(int userId) {
        List<Order> list = orderMapper.selectListByUserId(userId);
        PageResponse response = new PageResponse();
        response.setRows(list);
        response.setTotal(list.size());
        return response;
    }

    @Override
    public ServerResponse item(String orderNo) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        User admin = userMapper.selectByPrimaryKey(userId);
        if (admin.getRole() != 0) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NOT_ADMIN.getCode(), ResponseCode.NOT_ADMIN.getDesc());
        }
        List<OrderItem> list = orderItemMapper.selectByOrderNo(orderNo);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public PageResponse orderItemList(String orderNo) {
        List<OrderItem> list = orderItemMapper.selectByOrderNo(orderNo);
        List<OrderItemVo> responseList = new ArrayList<>();
        for (OrderItem orderItem : list) {
            OrderItemVo vo = new OrderItemVo();
            vo.setBookId(orderItem.getBookid());
            Book book = bookMapper.selectByPrimaryKey(orderItem.getBookid());
            vo.setBookName(book.getName());
            vo.setPrice(book.getPrice());
            vo.setQuantity(orderItem.getQuantity());
            responseList.add(vo);
        }
        PageResponse response = new PageResponse();
        response.setTotal(responseList.size());
        response.setRows(responseList);
        return response;
    }

    @Override
    public PageResponse findOrderList(String orderNo) {
        orderNo = new StringBuffer("%").append(orderNo).append("%").toString();
        List<Order> list = orderMapper.selectOrderList(orderNo);
        PageResponse response = new PageResponse();
        response.setRows(list);
        response.setTotal(list.size());
        return response;
    }
}
