package com.gxy.vbook.service.impl;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.*;
import com.gxy.vbook.pojo.Book;
import com.gxy.vbook.pojo.DonateBook;
import com.gxy.vbook.pojo.OrderItem;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.BookService;
import com.gxy.vbook.utils.BigDecimalUtil;
import com.gxy.vbook.vo.BookRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private DonateBookMapper donateBookMapper;

    /**
     * 保存二手书
     * @param book
     * @return
     */
    @Override
    public ServerResponse save(Book book) {
        // 计算折旧金额
        BigDecimal value = BigDecimalUtil.mul(book.getOriginalPrice(),book.getDiscount().doubleValue() / 10);
        book.setPrice(value.doubleValue());
        // 插入二手书
        bookMapper.updateByPrimaryKeySelective(book);
        // 返回正确的状态码
        return ServerResponse.createBySuccess(book);
    }

    @Override
    public ServerResponse saveBookImage(Book book) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        book.setUserId(userId);
        book.setStatus(1);
        // 插入二手书
        bookMapper.insert(book);
        return ServerResponse.createBySuccess(book);
    }

    /**
     * 通过 name 模糊查询二手书列表
     * @param name
     * @return
     */
    @Override
    public PageResponse findList(String name) {
        // 拼接模糊查询的条件
        name = new StringBuffer().append("%").append(name).append("%").toString();
        List<Book> list = bookMapper.selectAllListByName(name);
        // 组装返回对象
        PageResponse response = new PageResponse<>();
        response.setRows(list);
        response.setTotal(list.size());
        return response;
    }

    /**
     * 添加购物车时判断是否是自己的二手书
     * @param id
     * @param userId
     * @return
     */
    @Override
    public ServerResponse isMine(Integer id, Integer userId) {
        // 通过二手书ID以及用户ID判断是否是自己的二手书
        Book book = bookMapper.selectByBookIdAndUserId(id,userId);
        if (book != null) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 推荐列表
     * @return
     */
    @Override
    public PageResponse recommendedList() {
        // 按照评分对所有用户排序
        List<User> list = userMapper.selectListOrderByLevel();
        // 存储推荐二手书
        List<Book> bookList = new ArrayList<>();
        for (User user : list) {
            Integer userId = user.getId();
            List<Book> userBookList = bookMapper.selectByUserId(userId);
            if (userBookList.size() != 0) {
                bookList.addAll(userBookList);
            }
        }
        // 组装返回对象
        PageResponse response = new PageResponse();
        response.setTotal(bookList.size());
        response.setRows(bookList);
        return response;
    }

    @Override
    public ServerResponse getBook(Integer id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(book);
    }

    @Override
    public ServerResponse bookSellRecord() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        // 通过 userId 查询自己售卖的二手书
        List<Book> bookList = bookMapper.selectByUserId(userId);
        List<BookRecordVo> bookRecordVos = new ArrayList<>();
        for (Book book : bookList) {
            BookRecordVo record = new BookRecordVo();
            record.setBookId(book.getId());
            record.setBookName(book.getName());
            record.setUserId(userId);
            record.setImgName(book.getImgName());
            record.setPrice(book.getPrice());
            Integer status = book.getStatus();
            if (status == 1) {
                record.setStatus(Const.BookStatus.ON_SALE.getDesc());
            }else if (status == 0) {
                OrderItem orderItem = orderItemMapper.selectByBookId(book.getId());
                User buyerUser = userMapper.selectByPrimaryKey(orderItem.getUserId());
                record.setBuyerUserId(buyerUser.getId());
                record.setBuyerUserName(buyerUser.getName());
                record.setStatus(Const.BookStatus.OUT_SALE.getDesc());
            }
            bookRecordVos.add(record);
        }
        return ServerResponse.createBySuccess(bookRecordVos);
    }

    @Override
    public ServerResponse bookDonateRecord() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        List<DonateBook> list = donateBookMapper.selectAllListByUserId(userId);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse delete(Integer bookId) {
        bookMapper.deleteByPrimaryKey(bookId);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse upOrDown(Integer bookId, Integer bookStatus) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
        book.setStatus(bookStatus);
        bookMapper.updateByPrimaryKey(book);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse imgRecommendList() {
        List<Book> list = bookMapper.selectRecommendList();
        return ServerResponse.createBySuccess(list);
    }
}
