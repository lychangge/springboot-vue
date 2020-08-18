package com.js.service.impl;

import com.js.dao.CoachDao;
import com.js.pojo.Coach;
import com.js.service.CoachService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CoachServiceImpl implements CoachService {
    @Resource
    private CoachDao coachDao;
    @Override
    public List<Coach> getAllCoach() {
        return coachDao.getAllCoach();
    }
}
