package com.sasanka.cw.controller;


import com.sasanka.cw.model.Schedule;
import com.sasanka.cw.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/addSchedule")
    public Schedule saveSchedule(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }

}
