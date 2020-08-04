package com.sasanka.cw.service;

import com.sasanka.cw.model.Motorbike;
import com.sasanka.cw.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAllBikes() {

        return motorbikeRepository.findAll();

    }

    public Motorbike getByPlateNo(String plateNo) {

        return motorbikeRepository.findByPlateNo(plateNo);

    }

}

