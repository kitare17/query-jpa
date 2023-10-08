package com.example.demo.onetomany.example.controller;

import com.example.demo.onetomany.example.entity.Category;
import com.example.demo.onetomany.example.service.CategoryService;
import com.example.demo.onetomany.example.service.RegistrationService;
import com.example.demo.onetomany.example.service.TournamentService;
import com.example.demo.onetomany.example.entity.Registration;
import com.example.demo.onetomany.example.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    CategoryService categoryService;
    @GetMapping
    public List<Tournament> allTournaments() {
        return tournamentService.allTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable int id){
        return tournamentService.getTournament(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return tournamentService.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return tournamentService.removeRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id) {
        tournamentService.deleteTournament(id);
    }

    @PutMapping("/{id}/categories/{category_id}")
     public Tournament addCategory(@PathVariable int id,@PathVariable int category_id ){
        Category category=categoryService.getCategory(category_id);
        return tournamentService.addCategory(id,category);
    }
}
