package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /*
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return (UserDetails) userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }



    public User save(User newUser) {
        if (newUser.getId() == null) {
            newUser.setCreatedAt(LocalDateTime.now());
        }

        newUser.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(newUser);
    }

}
