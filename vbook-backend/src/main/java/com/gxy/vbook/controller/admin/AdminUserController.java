package com.gxy.vbook.controller.admin;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public ServerResponse list(){
        return userService.list();
    }
}
