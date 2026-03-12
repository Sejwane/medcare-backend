
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
public Optional<User> userUpdate(Integer id, User update) {

    if (update.getFirstName() == null || update.getFirstName().isBlank()) {
        throw new IllegalArgumentException("First name cannot be empty");
    }

    if (update.getEmail() == null || update.getEmail().isBlank()) {
        throw new IllegalArgumentException("Email cannot be empty");
    }

    /*Well this update using the validation in this file works fine but as i scale the system
    it gets to a point where i have alot of if statements and it wont be sustainable so all the small 
    updates will remain as such but all the others will need DTO's
    */

    return userRepository.findById(id)
            .map(user -> {
                user.setFirstName(update.getFirstName());
                user.setEmail(update.getEmail());

                if (update.getLastName() != null && !update.getLastName().isBlank()) {
                    user.setLastName(update.getLastName());
                }

                return userRepository.save(user);
            });
}

}
