package com.lx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author xiongyi
 * @Date 2019/2/21 15:35
 */
//@RequestMapping("/user")
    @Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
