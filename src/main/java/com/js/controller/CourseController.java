package com.js.controller;

import com.js.pojo.Course;
import com.js.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/getAll")
    public List<Course> getAllCourse(){
        List<Course> list = courseService.getAllCourseS();
        return list;
    }
}
