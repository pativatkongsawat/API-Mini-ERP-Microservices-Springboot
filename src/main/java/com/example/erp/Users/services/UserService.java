package com.example.erp.Users.services;

import java.util.List;

import com.example.erp.Users.model.User;
import com.example.erp.Users.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   public List<User> getAll(){
    return userRepository.findAll();
   }
    
}
