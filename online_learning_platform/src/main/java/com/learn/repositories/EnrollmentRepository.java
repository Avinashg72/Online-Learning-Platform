package com.learn.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.entities.Enrollment;

@Repository
public class EnrollmentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Enrollment enrollUser(Enrollment enrollment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(enrollment);
            transaction.commit();
            return enrollment;
        }
    }

    public Enrollment getEnrollmentById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Enrollment.class, id);
        }
    }

    public List<Enrollment> getAllEnrollments() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Enrollment", Enrollment.class).list();
        }
    }

    public void deleteEnrollment(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Enrollment enrollment = session.get(Enrollment.class, id);
            if (enrollment != null) session.delete(enrollment);
            transaction.commit();
        }
    }
}