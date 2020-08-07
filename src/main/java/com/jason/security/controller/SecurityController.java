package com.jason.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2020/8/7 16:36
 * @Author by 尘心
 */
@RestController
public class SecurityController {

    @GetMapping("/")
    public String index() {
        return "登录成功!";
    }
}
