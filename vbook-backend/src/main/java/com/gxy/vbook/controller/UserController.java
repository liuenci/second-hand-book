package com.gxy.vbook.controller;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ServerResponse<User> register(@RequestParam("name") String name, @RequestParam("password") String password) {
        return userService.save(name, password);
    }

}
