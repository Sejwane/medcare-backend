
package com.medcare.backend.Service;

import com.medcare.backend.Model.User;
import com.medcare.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // The Scrambler
import org.springframework.stereotype.Service;


@Service

public class UserService {
    @Autowired
     
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    public User registerUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

}
