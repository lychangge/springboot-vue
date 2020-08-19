package com.js.service;

import com.js.pojo.User;

public interface UserService {

    User UserRegistry(User user);

    Integer add(User user);

    User userlogin(String tel, String password);
}
