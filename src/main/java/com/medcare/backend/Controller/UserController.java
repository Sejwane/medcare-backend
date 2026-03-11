package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User update){
        try {
            Optional<User> updatedUser=userService.userUpdate(id, update);

            if (updatedUser.isPresent()){
                return ResponseEntity.ok(updatedUser.get());
            }else {
                return ResponseEntity.status(404).build();
            }
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }

    }
}