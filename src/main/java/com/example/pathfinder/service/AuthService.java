package com.example.pathfinder.service;

import com.example.pathfinder.model.User;
import com.example.pathfinder.model.dto.UserRegistrationDTO;
import com.example.pathfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegistrationDTO registrationDTO){
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }
        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if(byEmail.isPresent()){
            throw  new RuntimeException("email.used");
        }

        User user=new User(
                registrationDTO.getUsername(),
                registrationDTO.getPassword(),
                registrationDTO.getEmail(),
                registrationDTO.getFullname(),
                registrationDTO.getAge()
        );

        this.userRepository.save(user);
    }
}
