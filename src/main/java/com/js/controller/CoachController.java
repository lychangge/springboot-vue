package com.js.controller;


import com.js.pojo.Coach;
import com.js.service.CoachService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CoachController {
    @Resource
    private CoachService coachService;
    @RequestMapping("/getAllCoach")
    public List<Coach> getAllCoach(){
        return coachService.getAllCoach();
    }
}
