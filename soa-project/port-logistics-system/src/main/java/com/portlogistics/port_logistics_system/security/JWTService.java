package com.portlogistics.port_logistics_system.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final String SECRET_KEY =
            "portLogisticsSecretKeyForJwtAuthentication2026";

    public String generateToken(String email, String role) {

        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public Claims validateToken(String token) {

        return Jwts.parser()
                .verifyWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}