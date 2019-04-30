package com.gxy.vbook.utils;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 角色工具类
 */
@Component
public class RoleUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 判断是否是管理员
     * @return
     */
    public ServerResponse isAdmin(){
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return ServerResponse.createBySuccess();
    }
}
