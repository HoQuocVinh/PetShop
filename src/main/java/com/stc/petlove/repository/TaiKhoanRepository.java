package com.stc.petlove.repository;

import com.stc.petlove.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {
}
