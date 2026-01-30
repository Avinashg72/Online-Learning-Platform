package com.skillelevate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillelevate.entity.Course;
import com.skillelevate.entity.User;
import com.skillelevate.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getInstructorCourses(User instructor) {
        return courseRepository.findByInstructor(instructor);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
