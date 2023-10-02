package com.example.demo.relation_example;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    @Column(name = "room_name")
    private String roomName;

}
