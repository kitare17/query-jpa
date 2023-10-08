package com.example.demo.onetomany.example.service;

import com.example.demo.onetomany.example.entity.Player;
import com.example.demo.onetomany.example.entity.Registration;
import com.example.demo.onetomany.example.respository.PlayerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRespository respository;

    public List<Player> allPlayers() {
        return respository.findAll();
    }

    public Player getPlayer(int id) {
        return respository.findById(id).get();
    }

    public Player addPlayer(Player player) {
        player.setId(0);

        return respository.save(player);
    }

    public void deletePlayer(int id) {
        respository.deleteById(id);
    }

    //    public Player assignProfile(int id, P)

    //add new registration for player
    public Player assignRegistration(int id, Registration registration) {
        Player player = respository.findById(id).get();
        player.registrationPlayer(registration);
        return respository.save(player);
    }

    // remove the registration for player
    public Player removeRegistration(int id,Registration registration){
        Player player =respository.findById(id).get();
        player.removeRegistration(registration);
        return respository.save(player);
    }

}
