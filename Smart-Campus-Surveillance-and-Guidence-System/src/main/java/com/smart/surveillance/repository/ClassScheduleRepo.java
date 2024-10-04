package com.smart.surveillance.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.smart.surveillance.model.ClassSchedule;

public interface ClassScheduleRepo extends MongoRepository<ClassSchedule, Long> {

}
