package com.gxy.vbook.controller;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("register")
    public ServerResponse<User> register(@RequestParam("name") String name, @RequestParam("password") String password) {
        return userService.save(name, password);
    }

    @PostMapping("login")
    public ServerResponse<User> login(HttpSession session, @RequestParam("name") String name, @RequestParam("password") String password) {
        ServerResponse<User> response = userService.login(name,password);
        if (response.isSuccess()) {
            redisTemplate.opsForValue().set(Const.CURRENT_USER, response.getData().getId().toString());
        }
        return response;
    }

    @PostMapping("update")
    public ServerResponse<User> update(@RequestParam("id") Integer id, @RequestParam("phone") String phone, @RequestParam("email") String email) {
        return userService.update(id, phone, email);
    }

    @GetMapping("profile")
    public ServerResponse<User> profile(){
        return userService.profile();
    }
}
