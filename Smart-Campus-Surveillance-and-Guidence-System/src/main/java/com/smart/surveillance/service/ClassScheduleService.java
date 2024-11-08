package com.smart.surveillance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.surveillance.model.ClassSchedule;
import com.smart.surveillance.repository.ClassScheduleRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClassScheduleService {

    @Autowired
    private ClassScheduleRepo classScheduleRepo;

    public List<ClassSchedule> getAllSchedules() {
        return classScheduleRepo.findAll();
    }

    public Optional<ClassSchedule> getSchedulesBySection(String id) {
        return classScheduleRepo.findById(id);
    }

    public ClassSchedule addClassSchedule(ClassSchedule classSchedule) {
        return classScheduleRepo.save(classSchedule);
    }

    public ClassSchedule updateClassSchedule(String id, ClassSchedule updatedSchedule) {
        ClassSchedule existingSchedule = classScheduleRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        existingSchedule.setSubject(updatedSchedule.getSubject());
        existingSchedule.setDay(updatedSchedule.getDay());
        existingSchedule.setStartTime(updatedSchedule.getStartTime());
        existingSchedule.setEndTime(updatedSchedule.getEndTime());
        return classScheduleRepo.save(existingSchedule);
    }

    public void deleteClassSchedule(String id) {
        classScheduleRepo.deleteById(id);
    }
}
