package com.strive.backend.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strive.backend.dto.RegisterRequest;
import com.strive.backend.model.User;
import com.strive.backend.repository.UserRepository;


@Service
public class AuthService {
    
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest request) {

        User user = new User(
            request.getName(),
            request.getEmail(),
            request.getPassword()
        );

        return userRepository.save(user);
        
    }

    public User login(String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
  

}
