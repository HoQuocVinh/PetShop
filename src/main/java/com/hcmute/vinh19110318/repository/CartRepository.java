package com.hcmute.vinh19110318.repository;

import com.hcmute.vinh19110318.entities.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
}
