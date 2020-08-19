package com.js.dao;

import com.js.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User UserRegistry(User user);

    Integer add(User user);
}
