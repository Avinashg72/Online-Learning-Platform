package com.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entities.Enrollment;
import com.learn.services.EnrollmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    
    @PostMapping("/enroll")
    public Enrollment enrollUser(@RequestBody Enrollment enrollment) {
        return enrollmentService.enrollUser(enrollment);
    }
    
    @GetMapping("/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }
    
    @GetMapping("/all")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}