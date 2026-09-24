package com.portlogistics.port_logistics_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portlogistics.port_logistics_system.entity.User;
import com.portlogistics.port_logistics_system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}