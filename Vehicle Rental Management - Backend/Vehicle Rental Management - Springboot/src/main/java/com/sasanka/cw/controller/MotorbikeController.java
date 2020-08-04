package com.sasanka.cw.controller;

import com.sasanka.cw.model.Motorbike;
import com.sasanka.cw.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;



    @RequestMapping("/getAllBikes")
    public List<Motorbike> getAllBikes() {
        return motorbikeService.getAllBikes();

    }
}