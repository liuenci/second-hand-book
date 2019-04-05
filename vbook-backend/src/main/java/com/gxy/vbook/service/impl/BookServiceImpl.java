package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.BookMapper;
import com.gxy.vbook.pojo.Book;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public ServerResponse save(int id,String name,Double price) {
        Book book = new Book();
        book.setUserid(id);
        book.setName(name);
        book.setPrice(new BigDecimal(String.valueOf(price)));
        book.setStatus(Byte.parseByte("1"));
        bookMapper.insert(book);
        return ServerResponse.createBySuccess(book);
    }

    @Override
    public ServerResponse findList(String name) {
        List<Book> list = bookMapper.selectListByName(name);
        return ServerResponse.createBySuccess(list);
    }
}
