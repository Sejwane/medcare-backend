
package com.medcare.backend.Service;

import com.medcare.backend.Model.User;
import com.medcare.backend.Repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // The Scrambler
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


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

    public List<User>getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> userUpdate(Integer id,User update){
        Optional<User> currentUser=userRepository.findById(id);

        if (currentUser.isPresent()){
            User newDetails = currentUser.get();

            newDetails.setFirstName(update.getFirstName());
            newDetails.setLastName(update.getLastName());
            newDetails.setEmail(update.getEmail());

            User newUserDetails=userRepository.save(newDetails);

            return Optional.of(newUserDetails);
        }

        return Optional.empty();
    }

}
