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

    public Optional<ClassSchedule> getSchedulesBySection(Long id) {
        return classScheduleRepo.findById(id);
    }

    public ClassSchedule addClassSchedule(ClassSchedule classSchedule) {
        return classScheduleRepo.save(classSchedule);
    }

    public ClassSchedule updateClassSchedule(Long id, ClassSchedule updatedSchedule) {
        ClassSchedule existingSchedule = classScheduleRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        existingSchedule.setSec(updatedSchedule.getSec());
        existingSchedule.setSubject(updatedSchedule.getSubject());
        existingSchedule.setDay(updatedSchedule.getDay());
        existingSchedule.setTime(updatedSchedule.getTime());
        return classScheduleRepo.save(existingSchedule);
    }

    public void deleteClassSchedule(Long id) {
        classScheduleRepo.deleteById(id);
    }
}
