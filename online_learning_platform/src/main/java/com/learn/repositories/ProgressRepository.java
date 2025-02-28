package com.learn.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.entities.Progress;

@Repository
public class ProgressRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Progress updateProgress(Progress progress) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(progress);
            session.getTransaction().commit();
        }
		return progress;
    }

    public Progress getProgressById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Progress.class, id);
        }
    }

    public List<Progress> getAllProgress() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Progress", Progress.class).list();
        }
    }

    public Object deleteProgress(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Progress progress = session.get(Progress.class, id);
            if (progress != null) session.delete(progress);
            transaction.commit();
        }
		return id;
    }
    public List<Progress> getProgressByUser(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Progress WHERE enrollment.user.id = :userId", Progress.class)
                    .setParameter("userId", userId)
                    .list();
        }
    }

    
}

