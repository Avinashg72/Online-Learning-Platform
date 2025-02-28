package com.learn.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.entities.Lesson;

@Repository
public class LessonRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Lesson addLesson(Lesson lesson) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(lesson);
            transaction.commit();
            return lesson;
        }
    }

    public Lesson getLessonById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Lesson.class, id);
        }
    }

    public List<Lesson> getAllLessons() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Lesson", Lesson.class).list();
        }
    }

    public Lesson updateLesson(Lesson lesson) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(lesson);
            transaction.commit();
            return lesson;
        }
    }

    public void deleteLesson(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, id);
            if (lesson != null) session.delete(lesson);
            transaction.commit();
        }
    }
}