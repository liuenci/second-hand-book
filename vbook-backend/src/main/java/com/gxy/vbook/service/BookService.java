package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.Book;

public interface BookService {
    ServerResponse save(Book book);

    PageResponse findList(String name);

    ServerResponse isMine(Integer id,Integer userId);

    PageResponse recommendedList();
}
