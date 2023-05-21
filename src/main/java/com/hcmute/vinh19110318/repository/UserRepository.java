package com.hcmute.vinh19110318.repository;

import com.hcmute.vinh19110318.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{email: ?0}")
    Optional<User> findByEmail(String email);
}
