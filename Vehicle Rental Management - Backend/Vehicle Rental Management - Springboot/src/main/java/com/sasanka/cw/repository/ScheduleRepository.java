package com.sasanka.cw.repository;

import com.sasanka.cw.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    public Schedule findByvehiclePlateNo(String scheduleIdentification);

}
