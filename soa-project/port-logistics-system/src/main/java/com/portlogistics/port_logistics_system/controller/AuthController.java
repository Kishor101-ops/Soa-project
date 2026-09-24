package com.portlogistics.port_logistics_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.portlogistics.port_logistics_system.dto.LoginRequest;
import com.portlogistics.port_logistics_system.dto.LoginResponse;
import com.portlogistics.port_logistics_system.entity.User;
import com.portlogistics.port_logistics_system.repository.UserRepository;
import com.portlogistics.port_logistics_system.security.JWTService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JWTService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return ResponseEntity.status(401)
                    .body("Invalid email or password");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return ResponseEntity.status(401)
                    .body("Invalid email or password");
        }

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole());

        LoginResponse response = new LoginResponse(
                token,
                user.getEmail(),
                user.getRole());

        return ResponseEntity.ok(response);
    }
}