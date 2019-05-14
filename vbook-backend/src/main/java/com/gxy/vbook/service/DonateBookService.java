package com.gxy.vbook.service;

import java.util.List;
import com.gxy.vbook.pojo.DonateBook;

/**
 * 捐赠二手书接口
 */
public interface DonateBookService{
    /**
     * 新增捐赠二手书
     * @param donateBook
     * @return
     */
    int insert(DonateBook donateBook);

    /**
     * 获取所有的捐赠二手书
     * @return
     */
    List<DonateBook> selectAllList();

    List<DonateBook> selectListByUserId();
}
