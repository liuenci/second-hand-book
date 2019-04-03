package com.gxy.vbook.dao;

import com.gxy.vbook.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);


}