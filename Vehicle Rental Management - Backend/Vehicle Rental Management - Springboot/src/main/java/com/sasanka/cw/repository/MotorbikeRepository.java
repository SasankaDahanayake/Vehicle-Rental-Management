package com.sasanka.cw.repository;

import com.sasanka.cw.model.Motorbike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepository extends MongoRepository<Motorbike, String> {

        public Motorbike findByPlateNo(String plateNo);

}

