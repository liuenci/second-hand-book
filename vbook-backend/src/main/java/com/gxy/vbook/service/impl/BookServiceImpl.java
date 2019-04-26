package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.BookMapper;
import com.gxy.vbook.pojo.Book;
import com.gxy.vbook.service.BookService;
import com.gxy.vbook.utils.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public ServerResponse save(Book book) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        book.setUserId(userId);
        book.setStatus(1);
        // 计算折旧金额
        BigDecimal value = BigDecimalUtil.mul(book.getOriginalPrice(),book.getDiscount().doubleValue() / 10);
        book.setPrice(value.doubleValue());
        bookMapper.insert(book);
        return ServerResponse.createBySuccess(book);
    }

    @Override
    public PageResponse findList(String name) {
        name = new StringBuffer().append("%").append(name).append("%").toString();
        List<Book> list = bookMapper.selectListByName(name);
        PageResponse<Book> response = new PageResponse<>();
        response.setRows(list);
        response.setTotal(list.size());
        return response;
    }

    @Override
    public ServerResponse isMine(Integer id, Integer userId) {
        Book user = bookMapper.selectByBookIdAndUserId(id,userId);
        if (user != null) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }
}
