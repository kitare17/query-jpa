package com.example.demo.onetomany.example.respository;

import com.example.demo.onetomany.example.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {

}
