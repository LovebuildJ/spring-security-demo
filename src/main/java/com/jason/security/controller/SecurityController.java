package com.jason.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 测试
 * @Date 2020/8/7 16:36
 * @Author by 尘心
 */
@Controller
public class SecurityController {

    @ResponseBody
    @GetMapping("/")
    public String index() {
        return "登录成功!";
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView toIndex() {
        return new ModelAndView("index");
    }
}
