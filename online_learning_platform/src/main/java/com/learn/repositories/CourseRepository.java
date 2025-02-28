package com.learn.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.entities.Course;

@Repository
public class CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Course addCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return course;
        }
    }

    public Course getCourseById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, id);
        }
    }

    public List<Course> getAllCourses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }

    public Course updateCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
            return course;
        }
    }

    public void deleteCourse(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) session.delete(course);
            transaction.commit();
        }
    }
}