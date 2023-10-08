package com.example.demo.onetomany.example.respository;


import com.example.demo.onetomany.example.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRespository extends JpaRepository<Player,Integer> {

}
