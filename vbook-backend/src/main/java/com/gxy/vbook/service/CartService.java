package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;

/**
 * 购物车接口
 */
public interface CartService {
    /**
     * 购物车列表
     * @param userId
     * @return
     */
    PageResponse list(int userId);

    /**
     * 添加二手书到购物车
     * @param bookId
     * @param count
     * @param userId
     * @return
     */
    ServerResponse add(int bookId,int count,int userId);
}
