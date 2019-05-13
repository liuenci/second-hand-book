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

    ServerResponse saveBookImage(Book book);

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

    /**
     * 通过二手书主键ID查找二手书信息
     * @param id
     * @return
     */
    ServerResponse getBook(Integer id);

    /**
     * 当前用户的卖书记录
     * @return
     */
    ServerResponse bookSellRecord();

    /**
     * 当前用户的捐赠记录
     * @return
     */
    ServerResponse bookDonateRecord();

    /**
     * 管理员
     * 删除二手书
     * @return
     */
    ServerResponse delete(Integer bookId);

    ServerResponse upOrDown(Integer bookId,Integer bookStatus);
}
