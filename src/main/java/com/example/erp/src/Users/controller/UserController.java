package com.example.erp.src.Users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Helper.ApiResponse;
import com.example.erp.src.Users.dto.CreateUser;
import com.example.erp.src.Users.model.User;
import com.example.erp.src.Users.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Integer id) {

        Optional<User> data = userService.getById(id);

        if (data.isPresent()) {

            ApiResponse<User> res = new ApiResponse<>("302", "User Found", data.get());

            return ResponseEntity.status(HttpStatus.FOUND).body(res);

        } else {
            ApiResponse<User> res = new ApiResponse<>("404", "User Not Found", data.get());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }

    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<User>> CreateUser(@RequestBody CreateUser data) {

        User newUser = userService.CreateNewUser(data);

        ApiResponse<User> res = new ApiResponse<>("201", "Create User", newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse<User>> UpdateUser(@RequestBody CreateUser data, @RequestParam Integer id) {

        Optional<User> updatedUser = userService.UpdateUser(data, id);

        ApiResponse<User> res = new ApiResponse<>("200", "User Updated", updatedUser.get());

        return ResponseEntity.status(HttpStatus.OK).body(res);

    }

    @DeleteMapping("/")
    public ResponseEntity<Void> DeleteUser(@RequestParam Integer id) {

        userService.DeleteUser(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/s")
    public ResponseEntity<ApiResponse<User>> SoftDeleteUser(@RequestParam Integer id) {

        Optional<User> user = userService.SoftDeleteUser(id);

        ApiResponse<User> res = new ApiResponse<>("200", "Soft Delete ", user.get());

        return ResponseEntity.status(HttpStatus.OK).body(res);

    }

    @PostMapping("/a")
    public ResponseEntity<ApiResponse<List<User>>> CreateArrayUser(@RequestBody List<CreateUser> data){

        List<User> user = userService.CreateUserArray(data);

        ApiResponse<List<User>> res = new ApiResponse<>("201" , "Create User Success" , user);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
        
    }

}
