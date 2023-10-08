package com.example.demo.relation_example;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userinfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "userName")
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="roomId" ,referencedColumnName = "roomId")
    @JsonManagedReference
    private Room room;

}
