package com.js.service.impl;


import com.js.dao.IUserDao;
import com.js.pojo.User;
import com.js.service.IUserService;
import com.js.dao.UserDao;
import com.js.pojo.User;
import com.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User UserRegistry(User user) {
        return userDao.UserRegistry(user);
    }

    @Override
    public Integer add(User user) {
        return userDao.add(user);
    }
}
