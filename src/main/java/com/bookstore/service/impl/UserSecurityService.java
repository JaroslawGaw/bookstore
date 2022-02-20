package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException("Username not found");
        }

        return user;
    }

}
