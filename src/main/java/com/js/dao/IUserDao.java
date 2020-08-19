package com.js.dao;

import com.js.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface IUserDao {
    User userlogin(String tel, String password);

}
