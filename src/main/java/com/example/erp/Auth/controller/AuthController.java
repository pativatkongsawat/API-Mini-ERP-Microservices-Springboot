package com.example.erp.Auth.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Auth.model.AuthRequest;
import com.example.erp.Auth.model.AuthResponse;
import com.example.erp.Auth.service.AuthService;
import com.example.erp.Helper.ApiResponse;
import com.example.erp.Users.dto.CreateUser;
import com.example.erp.Users.model.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){

        this.authService = authService;

    }

    public ResponseEntity<ApiResponse<AuthResponse>> Login(@RequestBody AuthRequest req){

        AuthResponse data = authService.Login(req);

        ApiResponse<AuthResponse> res = new ApiResponse<>("200" , "Login Succes" , data); 

        return ResponseEntity.status(HttpStatus.OK).body(res);

    }

    public ResponseEntity<ApiResponse<User>> Register(@RequestBody CreateUser data){

        User user = authService.Register(data);

        ApiResponse<User> res = new ApiResponse<>("201" , "Register Success" , user);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }


    
}
