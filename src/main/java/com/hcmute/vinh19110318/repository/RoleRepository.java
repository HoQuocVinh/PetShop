package com.hcmute.vinh19110318.repository;

import com.hcmute.vinh19110318.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository  extends MongoRepository<Role, String> {
    Optional<Role> getRoleByRoleName(String roleName);
}
