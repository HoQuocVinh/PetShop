package com.hcmute.vinh19110318;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
