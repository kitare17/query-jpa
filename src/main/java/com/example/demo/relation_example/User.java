package com.example.demo.relation_example;


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
//    @Column(name = "roomId")
//    private int roomId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="roomId" ,referencedColumnName = "roomId")
    private Room room;

}
