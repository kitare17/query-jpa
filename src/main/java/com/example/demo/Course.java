package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Course")
public class Course {
    @Id
    private String id;
    private String name;

}
