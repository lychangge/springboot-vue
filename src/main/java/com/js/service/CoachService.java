package com.js.service;

import com.js.pojo.Coach;

import java.util.List;

public interface CoachService {

    List<Coach> getAllCoach();

    Coach getCoachByCid(Integer coach_id);

    Integer saveCoach(Coach coach);

    Integer updateCoach(Coach coach);

    Integer deleteCoachByCid(Integer coach_id);
}
