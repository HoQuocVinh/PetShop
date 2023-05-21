package com.hcmute.vinh19110318.repository;

import com.hcmute.vinh19110318.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
