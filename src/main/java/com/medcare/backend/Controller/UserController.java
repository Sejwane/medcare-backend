package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.DTO.UserUpdateDTO;
import com.medcare.backend.Model.User;
import com.medcare.backend.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.IllegalArgumentException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        //calls the service
        return userService.registerUser(user);
    }

    @GetMapping("/all")
    public List<User>getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User successfully archived.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to archive user.");
        }
    }
    

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody UserUpdateDTO updateDto){

        try {
            Optional<User> updatedUser=userService.userUpdate(id, updateDto);

            if (updatedUser.isPresent()){
                return ResponseEntity.ok(updatedUser.get());
            }else {
                return ResponseEntity.status(404).build();
            }
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }

    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<String> restoreUser(@PathVariable Integer id) {
        try {
            userService.restoreUser(id);
            return ResponseEntity.ok("User successfully recovered.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to recover user.");
        }
    }
}

