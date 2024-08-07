package com.example.ecomm.Service;

import com.example.ecomm.Models.User;
import com.example.ecomm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            System.err.println("Error occurred while fetching users: " + e.getMessage());
        }
    }



    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            System.err.println("Error occurred while fetching users: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}