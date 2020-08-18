package com.js.controller;


import com.js.pojo.User;
import com.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistryController {

    @Resource
    private UserService userService;

    @RequestMapping("/UserRegistry")
    public Integer UserRegistry(HttpServletRequest request,User user){
        User u =userService.UserRegistry(user);
        if(u==null){
         int res = userService.add(user);
            return 1;
        }else {
            return 0;
        }

    }
}
