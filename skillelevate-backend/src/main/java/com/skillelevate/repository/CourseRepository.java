package com.skillelevate.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillelevate.entity.Course;
import com.skillelevate.entity.User;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor(User instructor);
}
