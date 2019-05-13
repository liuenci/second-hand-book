package com.gxy.vbook.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.gxy.vbook.pojo.DonateBook;

@Mapper
public interface DonateBookMapper {
    /**
     * 插入捐赠二手书的记录
     * @param donateBook
     * @return
     */
    int insert(@Param("donateBook") DonateBook donateBook);

    /**
     * 插入记录中不为空的字段
     * @param donateBook
     * @return
     */
    int insertSelective(@Param("donateBook") DonateBook donateBook);

    /**
     * 插入多条记录
     * @param donateBooks
     * @return
     */
    int insertList(@Param("donateBooks") List<DonateBook> donateBooks);

    /**
     * 通过主键ID更新记录中不为空的记录
     * @param donateBook
     * @return
     */
    int updateByPrimaryKeySelective(@Param("donateBook") DonateBook donateBook);

    /**
     * 查询所有捐赠的二手书
     * @return
     */
    List<DonateBook> selectAllList();

    List<DonateBook> selectAllListByUserId(Integer userId);
}
