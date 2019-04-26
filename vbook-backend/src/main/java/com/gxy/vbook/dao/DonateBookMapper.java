package com.gxy.vbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.gxy.vbook.pojo.DonateBook;

@Mapper
public interface DonateBookMapper {
    int insert(@Param("donateBook") DonateBook donateBook);

    int insertSelective(@Param("donateBook") DonateBook donateBook);

    int insertList(@Param("donateBooks") List<DonateBook> donateBooks);

    int updateByPrimaryKeySelective(@Param("donateBook") DonateBook donateBook);

    List<DonateBook> selectAllList();
}
