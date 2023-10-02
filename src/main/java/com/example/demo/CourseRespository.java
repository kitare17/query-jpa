package com.example.demo;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CourseRespository extends JpaRepository<Course,Integer> {
    @Override
    List<Course> findAll();

    @Query(value = "SELECT u FROM Course u ")
    List<Course> getMyCourse();

    @Override
    Course saveAndFlush(Course course);
}
