package com.loctell.custom;

import com.loctell.modules.Admin;
import com.loctell.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class AdminDetailsImpl implements UserDetailsService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //WE FETCH OUR RECORDS FROM DB
        Admin admin = adminRepository.getUserByMail(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Could Not Found Admin");
        }
        CustomAdminDetails customUserData = new CustomAdminDetails(admin);
        return customUserData;
    }
}
