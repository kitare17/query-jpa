package com.example.demo.onetomany.example.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String playerName;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)

    private List<Registration> playerRegistrations;


    public void registrationPlayer(Registration registration) {
        playerRegistrations.add(registration);
        registration.setPlayer(this);
    }

    public void removeRegistration(Registration registration) {
        if (playerRegistrations != null) playerRegistrations.remove(registration);
        registration.setPlayer(null);
    }
}
