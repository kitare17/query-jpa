package com.example.demo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

}
