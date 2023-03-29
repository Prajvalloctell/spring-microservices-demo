package com.loctell.controller;

import com.loctell.enums.Roles;
import com.loctell.modules.User;
import com.loctell.repository.UserRepository;
import com.loctell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ResponseEntity<User> home(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> insertUser(@RequestBody User user) {
        user.setRoles(Roles.USER);
        User savedUser = userService.InsertUser(user);
        if (savedUser != null) {
            return ResponseEntity.ok("User saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save user");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User authentication = userService.findByUsernameAndPassword(user.getEmail(), user.getPassword());
        if (authentication != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User logged In");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Credentials");
        }
    }
}
