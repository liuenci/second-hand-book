package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.Book;

/**
 * 二手书接口
 */
public interface BookService {
    /**
     * 新增二手书
     * @param book
     * @return
     */
    ServerResponse save(Book book);

    /**
     * 模糊查询二手书集合
     * @param name
     * @return
     */
    PageResponse findList(String name);

    /**
     * 判断是否是自己的二手书
     * @param id
     * @param userId
     * @return
     */
    ServerResponse isMine(Integer id,Integer userId);

    /**
     * 二手书推荐列表
     * @return
     */
    PageResponse recommendedList();
}
