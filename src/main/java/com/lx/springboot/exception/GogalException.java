package com.lx.springboot.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GogalException
 * @Description TODO
 * @Author xiongyi
 * @Date 2019/2/21 18:23
 */
@ControllerAdvice
public class GogalException {


    @ExceptionHandler(AuthenticationException.class)
    public String uthenticationException(AuthenticationException e, Model model){
        String msg="";
        if (e instanceof UnknownAccountException || e instanceof IncorrectCredentialsException){
            msg="账号/密码不正确";

        }else if (e instanceof DisabledAccountException){
            msg="账号不可用";

        } else {
            msg="系统异常";

        }
        model.addAttribute("errorMsg",msg);
        return "forward:login";
    }

    @ExceptionHandler(UnauthorizedException.class)
    public  String unauthorizedException(){
        return "error/unauthorizedException";
    }



}
