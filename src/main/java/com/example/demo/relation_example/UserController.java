package com.example.demo.relation_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRespository userRespository;
    @Autowired
    private RoomRespository roomRespository;

    @GetMapping
    public List<User> getAllUser(){
        return userRespository.findAll();
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userRespository.save(user);
    }


}
