package com.stc.petlove;

import com.stc.petlove.entities.Role;
import com.stc.petlove.entities.User;
import com.stc.petlove.repository.RoleRepository;
import com.stc.petlove.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication
public class ClothesShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothesShopApplication.class, args);
    }

//        @Bean
//        CommandLineRunner runner(UserService userService, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
//        return args -> {
//            Role roleUser = new Role();
//            Role roleAdmin = new Role();
//            roleUser.setRoleName("USER");
//            roleAdmin.setRoleName("ADMIN");
//            roleRepository.save(roleUser);
//            roleRepository.save(roleAdmin);
//            User admin = new User();
//            admin.setFullName("Ho Quoc Vinh");
//            admin.setEmail("admin@clothes.com");
//            admin.setPassword(passwordEncoder.encode("Colthes@@admin"));
//            admin.setAddress(null);
//            Role adminRole = roleRepository.getRoleByRoleName("ADMIN").orElse(null);
//            admin.setRoles(Collections.singleton(adminRole));
//            userService.saveUser(admin);
//        };
//    }

}
