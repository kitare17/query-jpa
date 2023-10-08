package com.example.demo.onetomany.example.service;

import com.example.demo.onetomany.example.respository.RegistrationRepository;
import com.example.demo.onetomany.example.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    //get all registration
    public List<Registration> allRegistrations() {
        return registrationRepository.findAll();
    }

    //get registration by id
    public Registration getRegistration(int id) {
        return registrationRepository.findById(id).get();
    }

    //add registration
    public Registration addRegistration(Registration registration) {
        registration.setId(0);
        return registrationRepository.save(registration);
    }

    //delete registration
    public void deleteRegistration(int id) {
        registrationRepository.deleteById(id);
    }

}
