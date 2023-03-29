package com.loctell.custom;

import com.loctell.modules.User;
import com.loctell.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsImpl implements UserDetailsService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //WE FETCH OUR RECORDS FROM DB
        User user = userRepository.getUserByMail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could Not Found User");
        }
        CustomUserDetails customUserData = new CustomUserDetails(user);
        return customUserData;
    }
}
