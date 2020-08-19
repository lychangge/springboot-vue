package com.js.controller;


import com.js.pojo.Coach;
import com.js.service.CoachService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/getCoachByCid/{coach_id}")
    public Coach getCoachByCid(@PathVariable Integer coach_id){
        return coachService.getCoachByCid(coach_id);
    }

    @RequestMapping("/saveCoach")
    public  Integer saveCoach(@RequestBody Coach coach){
        return coachService.saveCoach(coach);
    }

    @RequestMapping("/updateCoach")
    public  Integer updateCoach(@RequestBody Coach coach){
        return coachService.updateCoach(coach);
    }

    @RequestMapping("/deleteCoachByCid/{coach_id}")
    public Integer deleteCoachByCid(@PathVariable Integer coach_id){
        return coachService.deleteCoachByCid(coach_id);
    }
}
