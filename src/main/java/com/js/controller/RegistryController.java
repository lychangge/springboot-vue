package com.js.controller;


import com.js.pojo.User;
import com.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;


@RestController
public class RegistryController {

    @Resource
    private UserService userService;

    @RequestMapping("/UserRegistry")
    public String UserRegistry(User user){
        User u =userService.UserRegistry(user);
            if (u == null){
                userService.add(user);
                return "success";
        }
        return "fail";
    }

}
