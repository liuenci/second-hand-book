package com.gxy.vbook.controller.admin;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * 后台用户接口
 */
@RestController
@RequestMapping("admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 查看已注册用户
     * @param name
     * @return
     */
    @RequestMapping("list")
    public PageResponse list(@RequestParam("name") String name){
        return userService.findUserList(name);
    }

    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("login")
    public ServerResponse login(@RequestParam("name") String name, @RequestParam("password") String password){
        ServerResponse response = userService.login(name,password);
        if (response.isSuccess()) {
            User user = (User) response.getData();
            if (user.getRole() == Const.Role.ROLE_ADMIN) {
                redisTemplate.opsForValue().set(Const.CURRENT_ADMIN,user.getId().toString());
            } else {
                return ServerResponse.createByErrorMessage("不是管理员，无法登录");
            }
        }
        return response;
    }
}
