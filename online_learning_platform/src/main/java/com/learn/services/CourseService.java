package com.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.Course;
import com.learn.repositories.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    public Course addCourse(Course course) {
        return courseRepository.addCourse(course);
    }
    
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }
    
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }
    
    public Course updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }
    
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }
}
