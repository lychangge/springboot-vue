package com.js.service.impl;


import com.js.dao.IUserDao;
import com.js.pojo.User;
import com.js.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;


    @Override
    public User userlogin(String tel, String password) {
        return userDao.userlogin(tel,password);
    }
}