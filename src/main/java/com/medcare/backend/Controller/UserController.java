package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.User;
import com.medcare.backend.Service.UserService;

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
}