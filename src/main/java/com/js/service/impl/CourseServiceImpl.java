package com.js.service.impl;

import com.js.dao.CourseDao;
import com.js.pojo.Course;
import com.js.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getAllCourseS() {
        return courseDao.getAllCourseD();
    }
}
