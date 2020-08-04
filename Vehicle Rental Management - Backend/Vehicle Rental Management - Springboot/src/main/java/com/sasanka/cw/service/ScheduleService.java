package com.sasanka.cw.service;

import com.sasanka.cw.model.Schedule;
import com.sasanka.cw.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {


    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedule() {

        return scheduleRepository.findAll();

    }

    public Schedule getByvehiclePlateNo(String vehiclePlateNo){

        return scheduleRepository.findByvehiclePlateNo(vehiclePlateNo);

    }

    public Schedule save(Schedule schedule) {

        return scheduleRepository.save(schedule);

    }
}
