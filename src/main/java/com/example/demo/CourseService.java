package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
  private CourseRespository courseRespository ;


    public List<Course> getAllCourse(){
        return  courseRespository.findAll();
    }

    public List<Course> getMyCourse(){
        return courseRespository.getMyCourse();
    }
}
