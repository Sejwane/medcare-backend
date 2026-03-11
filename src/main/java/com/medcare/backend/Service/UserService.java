
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
