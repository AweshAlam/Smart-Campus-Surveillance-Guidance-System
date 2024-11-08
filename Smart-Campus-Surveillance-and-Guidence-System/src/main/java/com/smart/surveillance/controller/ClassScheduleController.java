package com.smart.surveillance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smart.surveillance.model.ClassSchedule;
import com.smart.surveillance.service.ClassScheduleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classScheduleService;

    @GetMapping("/schedules")
    public List<ClassSchedule> getAllSchedules() {
        return classScheduleService.getAllSchedules();
    }

    @GetMapping("/schedule/{id}")
    public Optional<ClassSchedule> getSchedulesBySection(@PathVariable String id) {
        return classScheduleService.getSchedulesBySection(id);
    }

    @PostMapping("/schedule/add")
    public ClassSchedule addClassSchedule(@RequestBody ClassSchedule classSchedule) {
        return classScheduleService.addClassSchedule(classSchedule);
    }

    @PutMapping("/schedule/{id}")
    public ResponseEntity<ClassSchedule> updateClassSchedule(@PathVariable String id, @RequestBody ClassSchedule updatedSchedule) {
        ClassSchedule schedule = classScheduleService.updateClassSchedule(id, updatedSchedule);
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<Void> deleteClassSchedule(@PathVariable String id) {
        classScheduleService.deleteClassSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
