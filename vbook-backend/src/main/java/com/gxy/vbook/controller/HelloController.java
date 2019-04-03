package com.gxy.vbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        log.info("hello");
        return "hello";
    }
}
