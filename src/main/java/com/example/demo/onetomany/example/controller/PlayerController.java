package com.example.demo.onetomany.example.controller;


import com.example.demo.onetomany.example.entity.Player;
import com.example.demo.onetomany.example.entity.Registration;
import com.example.demo.onetomany.example.service.PlayerService;
import com.example.demo.onetomany.example.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<Player> allPlayer() {
        return playerService.allPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        registrationService.deleteRegistration(id);
    }

    @PutMapping("/{id}/registrations/{regitration_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int regitration_id) {
        Registration registration = registrationService.getRegistration(regitration_id);
        ;

        return playerService.assignRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{regitration_id}")
    public Player removeRegistration(@PathVariable int id, @PathVariable int regitration_id) {
        Registration registration = registrationService.getRegistration(regitration_id);
        return playerService.removeRegistration(id, registration);
    }
}
