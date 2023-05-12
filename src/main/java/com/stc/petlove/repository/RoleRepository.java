package com.stc.petlove.repository;

import com.stc.petlove.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository  extends MongoRepository<Role, String> {
}
