package com.hcmute.vinh19110318.repository;

import com.hcmute.vinh19110318.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
