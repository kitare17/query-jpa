package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourse(Model model) {
        model.addAttribute("course", new Course());
        return courseService.getMyCourse();
    }

    @PostMapping
    public String addNewCourse(@ModelAttribute Course course) {
        System.out.println("=>>>>>>>>>>>>>>>>>>" + course);
        courseService.addNewCourse(course);

        return "hello";
    }

    @DeleteMapping
    public String deleteCourse(@PathVariable int id) {
        courseService.removeCourse(id);
        return "hello";
    }
}
