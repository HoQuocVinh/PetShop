package com.stc.petlove.repository;

import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung, String> {
}
