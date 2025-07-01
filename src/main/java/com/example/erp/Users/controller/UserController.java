package com.example.erp.Users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Users.model.User;
import com.example.erp.Users.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public List<User> getAll(){
        return userService.getAll();
    }
    
}
