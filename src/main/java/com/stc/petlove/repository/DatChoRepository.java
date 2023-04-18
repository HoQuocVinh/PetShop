package com.stc.petlove.repository;

import com.stc.petlove.entities.DatCho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatChoRepository extends MongoRepository<DatCho, String> {
    @Query("{email: ?0}")
    Optional<DatCho> findDatChoByEmail(String email);
}
