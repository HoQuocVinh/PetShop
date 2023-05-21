package com.stc.petlove.controller;

import com.stc.petlove.entities.Role;
import com.stc.petlove.entities.User;
import com.stc.petlove.payload.ApiResponse;
import com.stc.petlove.repository.RoleRepository;
import com.stc.petlove.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class AuthController extends AbstractRestController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/auth/register")
    public ResponseEntity<ApiResponse> register(@RequestBody User user) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        Role userRole = roleRepository.getRoleByRoleName("USER").orElse(null);
        user.setRoles(Collections.singleton(userRole));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        apiResponse.setResult(userService.saveUser(user));
        apiResponse.setMessage("Register success!");
        return ResponseEntity.ok().body(apiResponse);
    }

}
