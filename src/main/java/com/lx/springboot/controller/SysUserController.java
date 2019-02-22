package com.lx.springboot.controller;


import com.lx.springboot.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
@Controller
public class SysUserController {

    @RequestMapping({"/login",""})
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(SysUser sysUser, HttpSession session){
        UsernamePasswordToken token=new UsernamePasswordToken(sysUser.getUsername(),sysUser.getPassword());
        SecurityUtils.getSubject().login(token);
        session.setAttribute("username",sysUser.getUsername());
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}
