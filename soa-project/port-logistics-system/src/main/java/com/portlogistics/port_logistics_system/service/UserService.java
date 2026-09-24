package com.portlogistics.port_logistics_system.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portlogistics.port_logistics_system.entity.User;
import com.portlogistics.port_logistics_system.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository repository,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}