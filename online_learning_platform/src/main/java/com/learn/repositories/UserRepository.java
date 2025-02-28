package com.learn.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.entities.User;
import com.learn.model.AuthRequest;

@Repository
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public String authenticate(AuthRequest authRequest) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.createQuery("FROM User WHERE email = :email AND password = :password", User.class)
                    .setParameter("email", authRequest.getEmail())
                    .setParameter("password", authRequest.getPassword())
                    .uniqueResult();
            return (user != null) ? "Login Successful" : "Invalid Credentials";
        }
    }

    public User register(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        }
    }

    public User getUserById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    public User updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return user;
        }
    }

    public void deleteUser(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) session.delete(user);
            transaction.commit();
        }
    }
    
    
}