package com.js.controller;

import com.js.pojo.Course;
import com.js.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/getOne/{course_id}")
    public Course selectOne(@PathVariable("course_id")String course_id){
        return courseService.findCourseOneS(course_id);
    }

    @RequestMapping("/update")
    public Integer updateCourse(@RequestBody Course course){

        return courseService.updateCourseS(course);
    }

    @RequestMapping("/add")
    public Integer addCourse(@RequestBody Course course){
        return  courseService.addCourseS(course);
    }

    @RequestMapping("/delete/{course_id}")
    public Integer deleteCourse(@PathVariable("course_id")String course_id){
        return  courseService.deleteCourseOneS(course_id);
    }
}
