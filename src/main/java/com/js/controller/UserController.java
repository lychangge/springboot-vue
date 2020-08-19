package com.js.controller;

import com.js.pojo.User;
import com.js.service.IUserService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/userlogin")
    public User userlogin(String tel,String password){
        return userService.userlogin(tel,password);
    }
}
