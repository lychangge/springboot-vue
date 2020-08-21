package com.js.service;

import com.js.pojo.Course;

import java.util.List;

public interface CourseService {

    //查询所有
    List<Course> getAllCourseS();

    //根据条件查询
    Course findCourseOneS(String course_id);

    //根据条件删除
    Integer deleteCourseOneS(String course_id);

    //增加数据
    Integer addCourseS(Course course);

    //根据条件修改数据
    Integer updateCourseS(Course course);

}
