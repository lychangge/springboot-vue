package com.js.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Course {
    private int course_id;
    private String course_name;
    private Date starttime;
    private Date endtime;
    private String caddress;
    private double cprice;
    private int number;
}
