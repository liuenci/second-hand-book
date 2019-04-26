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

    @Override
    public int insert(DonateBook donateBook){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        donateBook.setUserId(userId);
        return donateBookMapper.insert(donateBook);
    }

    @Override
    public int insertSelective(DonateBook donateBook){
        return donateBookMapper.insertSelective(donateBook);
    }

    @Override
    public int insertList(List<DonateBook> donateBooks){
        return donateBookMapper.insertList(donateBooks);
    }

    @Override
    public int updateByPrimaryKeySelective(DonateBook donateBook){
        return donateBookMapper.updateByPrimaryKeySelective(donateBook);
    }

    @Override
    public List<DonateBook> selectAllList() {
        return donateBookMapper.selectAllList();
    }
}
