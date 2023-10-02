package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HellloPage {
    @Autowired
    private  CourseService courseService;
    @GetMapping("/hello")
    public String getHello(Model model) {
        model.addAttribute("message", "hello world!!!");
        model.addAttribute("courses",courseService.getAllCourse());
        model.addAttribute("course",new Course());
        return "hello";
    }
}
