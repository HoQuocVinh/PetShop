package com.stc.petlove.repository;

import com.stc.petlove.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository  extends MongoRepository<Role, String> {
    Optional<Role> getRoleByRoleName(String roleName);
}
