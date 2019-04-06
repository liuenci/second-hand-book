package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.CartMapper;
import com.gxy.vbook.pojo.Cart;
import com.gxy.vbook.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public ServerResponse list(int userId) {
        List<Cart> list = cartMapper.selectListByUserId(userId);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse add(int bookId, int count,int userId) {
        Cart cart = new Cart();
        cart.setBookid(bookId);
        cart.setQuantity(count);
        cart.setUserid(userId);
        int result = cartMapper.insert(cart);
        return ServerResponse.createBySuccess(result);
    }
}