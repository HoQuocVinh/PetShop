package com.hcmute.vinh19110318.service.impl;

import com.hcmute.vinh19110318.entities.Role;
import com.hcmute.vinh19110318.entities.User;
import com.hcmute.vinh19110318.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Create by: IntelliJ IDEA
 *
 * @author : ThanhTrong
 * @mailto : ntt.thanhtrong@gmail.com
 * @created : 5/21/2023, Sunday
 * @filename : UserDetailServiceImpl
 **/
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getFullName())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(Role::getRoleName).toArray(String[]::new))
                .build();
    }
}
