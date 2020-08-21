package com.js.dao;

import com.js.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {

    //查询所有
    List<Course> getAllCourseD();

    //根据条件查询
    Course findCourseOne(String course_id);

    //根据条件删除
    Integer deleteCourseOne(String course_id);

    //增加数据
    Integer addCourse(Course course);

    //根据条件修改数据
    Integer updateCourse(Course course);

}
