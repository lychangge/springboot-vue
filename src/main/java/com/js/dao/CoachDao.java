package com.js.dao;

import com.js.pojo.Coach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CoachDao {
    List<Coach> getAllCoach();
}
