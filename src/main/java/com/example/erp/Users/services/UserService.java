package com.example.erp.Users.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.erp.Users.model.User;
import com.example.erp.Users.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   public List<User> getAll(){
    return userRepository.findAll();
   }
    
}
