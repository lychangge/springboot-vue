package com.js.dao;

import com.js.pojo.Coach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoachDao {
    List<Coach> getAllCoach();

    Coach getCoachByCid(Integer coach_id);

    Integer savaCoach(Coach coach);

    Integer updateCoach(Coach coach);

    Integer deleteCoachByCid(Integer coach_id);

}
