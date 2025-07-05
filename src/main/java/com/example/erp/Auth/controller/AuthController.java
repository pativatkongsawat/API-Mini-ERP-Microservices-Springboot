package com.example.erp.Auth.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.erp.Auth.model.AuthRequest;
import com.example.erp.Auth.model.AuthResponse;
import com.example.erp.Auth.service.AuthService;
import com.example.erp.helper.ApiResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){

        this.authService = authService;

    }

    public ResponseEntity<ApiResponse<AuthResponse>> Login(@RequestBody AuthRequest req){

        AuthResponse data = authService.Login(req);

        ApiResponse<AuthResponse> res = new ApiResponse<>("Login" , "Succes" , data); 

        return ResponseEntity.status(HttpStatus.OK).body(res);

    }


    
}
