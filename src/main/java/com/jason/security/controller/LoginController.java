package com.jason.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 登录
 * @Date 2020/8/11 16:07
 * @Author by 尘心
 */
@Controller
public class LoginController {

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "/login",method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView toLogin() {
        return new ModelAndView("login");
    }
}
