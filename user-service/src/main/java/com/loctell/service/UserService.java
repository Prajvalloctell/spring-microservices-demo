package com.loctell.service;

import com.loctell.modules.User;
import com.loctell.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**/
    public User InsertUser(User u)
    {
        return userRepository.save(u);
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

    public User findByUsernameAndPassword(String email, String password) {
        return userRepository.findByUsernameAndPassword(email, password);
    }
}
