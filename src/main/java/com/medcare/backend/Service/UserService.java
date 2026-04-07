
package com.medcare.backend.Service;

import com.medcare.backend.DTO.UserUpdateDTO;
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
public Optional<User> userUpdate(Integer id, UserUpdateDTO updateDto) {

    
    return userRepository.findById(id)
            .map(user -> {
                
                user.setFirstName(updateDto.getFirstName());
                user.setEmail(updateDto.getEmail());

                
                if (updateDto.getLastName() != null && !updateDto.getLastName().isBlank()) {
                    user.setLastName(updateDto.getLastName());
                }

                return userRepository.save(user);
            });
}

}


