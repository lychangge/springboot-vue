package com.js.controller;

import com.js.pojo.User;
import com.js.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/userlogin")
    public User userlogin(String tel,String password){
        return userService.userlogin(tel,password);
    }
}
