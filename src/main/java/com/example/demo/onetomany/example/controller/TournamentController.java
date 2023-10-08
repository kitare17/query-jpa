package com.example.demo.onetomany.example.controller;

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
    TournamentService service;

    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public List<Tournament> allTournaments() {
        return service.allTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable int id){
        return service.getTournament(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return service.addTournament(tournament);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return service.removeRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id) {
        service.deleteTournament(id);
    }
}
