package com.loctell.controller;

import com.loctell.enums.Roles;
import com.loctell.modules.Admin;
import com.loctell.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello from Admin Controller");
    }

    @PostMapping("/register")
    public ResponseEntity<String> insertAdmin(@RequestBody Admin admin) {
        admin.setRoles(Roles.ADMIN);
        Admin savedAdmin = adminService.InsertAdmin(admin);
        if (savedAdmin != null) {
            return ResponseEntity.ok("Admin saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save Admin");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody Admin admin) {
        Admin authentication = adminService.findByUsernameAndPassword(admin.getEmail(), admin.getPassword());
        if (authentication != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Admin logged In");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Credentials");
        }
    }
}
