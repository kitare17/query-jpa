package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HellloPage {
    @GetMapping("/hello")
    public String getHello(Model model) {
        model.addAttribute("message", "hello world!!!");
        return "hello";
    }
}
