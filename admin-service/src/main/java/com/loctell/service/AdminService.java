package com.loctell.service;


import com.loctell.modules.Admin;
import com.loctell.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**/
    public Admin InsertAdmin(Admin u)
    {
        return adminRepository.save(u);
    }


    public Admin findByUsernameAndPassword(String email, String password) {
        return adminRepository.findByUsernameAndPassword(email, password);
    }
}
