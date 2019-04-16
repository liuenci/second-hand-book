package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.BookMapper;
import com.gxy.vbook.dao.CartMapper;
import com.gxy.vbook.pojo.Cart;
import com.gxy.vbook.service.CartService;
import com.gxy.vbook.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private BookMapper bookMapper;
    @Override
    public PageResponse list(int userId) {
        List<Cart> list = cartMapper.selectListByUserId(userId);
        List<CartVo> cartVos = new ArrayList<>();
        for (Cart cart : list) {
            CartVo cartVo = new CartVo();
            String name = bookMapper.selectByPrimaryKey(cart.getBookid()).getName();
            cartVo.setBookId(cart.getBookid());
            cartVo.setName(name);
            cartVo.setPrice(bookMapper.selectByPrimaryKey(cart.getBookid()).getPrice());
            cartVo.setQuantity(cart.getQuantity());
            cartVos.add(cartVo);
        }
        PageResponse response = new PageResponse();
        response.setTotal(list.size());
        response.setRows(cartVos);
        return response;
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
