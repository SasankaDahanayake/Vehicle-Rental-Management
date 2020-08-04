package com.sasanka.cw.controller;

import com.sasanka.cw.model.Car;
import com.sasanka.cw.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/getAllCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();

    }

}
