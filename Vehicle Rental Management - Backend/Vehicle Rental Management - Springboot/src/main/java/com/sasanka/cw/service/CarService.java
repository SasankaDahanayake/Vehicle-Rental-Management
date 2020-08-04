    package com.sasanka.cw.service;

    import com.sasanka.cw.model.Car;
    import com.sasanka.cw.repository.CarRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class CarService {

        @Autowired
        private CarRepository carRepository;

        public List<Car> getAllCars() {

            return carRepository.findAll();

        }

        public Car getByPlateNo(String plateNo) {

            return carRepository.findByPlateNo(plateNo);

        }

    }

