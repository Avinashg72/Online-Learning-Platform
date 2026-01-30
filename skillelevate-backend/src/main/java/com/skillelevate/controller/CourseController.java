package com.skillelevate.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillelevate.entity.Course;
import com.skillelevate.entity.User;
import com.skillelevate.repository.UserRepository;
import com.skillelevate.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course, Principal principal) {
        User instructor = userRepository.findByEmail(principal.getName()).get();
        course.setInstructor(instructor);
        return courseService.createCourse(course);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/my")
    public List<Course> myCourses(Principal principal) {
        User instructor = userRepository.findByEmail(principal.getName()).get();
        return courseService.getInstructorCourses(instructor);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course deleted";
    }
}
