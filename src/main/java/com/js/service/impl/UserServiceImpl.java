package com.js.service.impl;

import com.js.dao.UserDao;
import com.js.pojo.User;
import com.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
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
