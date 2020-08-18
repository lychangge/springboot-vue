package com.js.dao;

import com.js.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {

    List<Course> getAllCourseD();

}
