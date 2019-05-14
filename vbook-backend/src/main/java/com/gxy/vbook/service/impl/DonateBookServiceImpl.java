package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.vbook.pojo.DonateBook;
import com.gxy.vbook.dao.DonateBookMapper;
import com.gxy.vbook.service.DonateBookService;

@Service
public class DonateBookServiceImpl implements DonateBookService{

    @Resource
    private DonateBookMapper donateBookMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 新增捐赠二手书
     * @param donateBook
     * @return
     */
    @Override
    public int insert(DonateBook donateBook){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        donateBook.setUserId(userId);
        return donateBookMapper.insert(donateBook);
    }

    /**
     * 查询所有的捐赠二手书集合
     * @return
     */
    @Override
    public List<DonateBook> selectAllList() {
        return donateBookMapper.selectAllList();
    }

    /**
     * 获取用户捐赠的二手书
     * @return
     */
    @Override
    public List<DonateBook> selectListByUserId() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return donateBookMapper.selectAllListByUserId(userId);
    }
}
