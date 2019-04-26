package com.gxy.vbook.service;

import java.util.List;
import com.gxy.vbook.pojo.DonateBook;
public interface DonateBookService{

    int insert(DonateBook donateBook);

    int insertSelective(DonateBook donateBook);

    int insertList(List<DonateBook> donateBooks);

    int updateByPrimaryKeySelective(DonateBook donateBook);

    List<DonateBook> selectAllList();
}
