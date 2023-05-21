package com.stc.petlove.repository;

import com.stc.petlove.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{email: ?0}")
    Optional<User> findByEmail(String email);
}
