package com.sasanka.cw.repository;

import com.sasanka.cw.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    public Car findByPlateNo(String plateNumber);

}
