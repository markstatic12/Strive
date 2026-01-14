package com.strive.backend.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strive.backend.model.User;
import com.strive.backend.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByID(Long id) {
        return userRepository.findById(id);
    }



}
