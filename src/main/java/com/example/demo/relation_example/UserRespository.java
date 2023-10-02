package com.example.demo.relation_example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRespository extends JpaRepository<User,Integer> {

}
