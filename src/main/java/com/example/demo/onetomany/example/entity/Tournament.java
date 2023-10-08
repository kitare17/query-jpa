package com.example.demo.onetomany.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tournamentName;
    private String tournamentLocation;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//, orphanRemoval=true)
    @JoinColumn(name = "tournament_id")
    private List<Registration> registrations = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tournament_categories", joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> playingCategories = new ArrayList<>();

    public void addRegistration(Registration reg) {
        registrations.add(reg);
    }

    //remove registration
    public void removeRegistration(Registration reg) {
        if (registrations != null)
            registrations.remove(reg);
    }
    public void addCategory(Category category){
        playingCategories.add(category);
    }

}
