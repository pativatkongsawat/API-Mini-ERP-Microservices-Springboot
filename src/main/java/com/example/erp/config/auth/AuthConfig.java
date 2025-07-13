package com.example.erp.Config.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import com.example.erp.src.Users.model.User;

import java.security.Key;
import java.util.Date;

@Component
public class AuthConfig {

    
    private static final String SECRET_KEY = "bXlTdXBlclNlY3JldEtleUdlbmVyYXRlZFdhdGVyRmFsbA==";

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail()) 
                .claim("userId", user.getId()) 
                .claim("email", user.getEmail())
                .claim("roleId", user.getRoleId())
                .claim("department", user.getDepartmentId())
                .claim("firstname", user.getFirstName())
                .claim("lastname", user.getLastName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) 
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
