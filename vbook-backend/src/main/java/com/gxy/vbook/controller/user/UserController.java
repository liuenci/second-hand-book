package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户接口
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 注册新用户
     *
     * @param name
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @PostMapping("register")
    public ServerResponse<User> register(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("phone") String phone) {
        return userService.save(name, password, email, phone);
    }

    /**
     * 用户登录
     *
     * @param name
     * @param password
     * @return
     */
    @PostMapping("login")
    public ServerResponse<User> login(@RequestParam("name") String name, @RequestParam("password") String password) {
        ServerResponse<User> response = userService.login(name, password);
        return response;
    }

    /**
     * 更新用户资料
     *
     * @param id
     * @param phone
     * @param email
     * @param password
     * @return
     */
    @PostMapping("update")
    public ServerResponse<User> update(@RequestParam("id") Integer id, @RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.update(id, phone, email, password);
    }

    /**
     * 查看用户资料
     *
     * @return
     */
    @GetMapping("profile")
    public ServerResponse<User> profile() {
        return userService.profile();
    }

    /**
     * 判断用户是否在线
     *
     * @return
     */
    @RequestMapping("online")
    public ServerResponse isLogin() {
        String userId = redisTemplate.opsForValue().get(Const.CURRENT_USER);
        if (userId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NOT_ADMIN.getDesc());
        }
        return userService.profile();
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public ServerResponse logout() {
        redisTemplate.delete(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }
    @RequestMapping("recharge")
    public ServerResponse recharge(@RequestParam("money") Double money) {
        return userService.recharge(money);
    }


}
