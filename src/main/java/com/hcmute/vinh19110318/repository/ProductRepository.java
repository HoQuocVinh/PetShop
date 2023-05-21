package com.hcmute.vinh19110318.repository;

import com.hcmute.vinh19110318.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
