package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public void addNewCourse(Course course){
        courseRespository.save(course);
    }

    public void removeCourse(int id){

        courseRespository.deleteById(id);
    }
}
