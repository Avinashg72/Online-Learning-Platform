package com.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.Enrollment;
import com.learn.repositories.EnrollmentRepository;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    public Enrollment enrollUser(Enrollment enrollment) {
        return enrollmentRepository.enrollUser(enrollment);
    }
    
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.getEnrollmentById(id);
    }
    
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }
    
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteEnrollment(id);
    }
}
