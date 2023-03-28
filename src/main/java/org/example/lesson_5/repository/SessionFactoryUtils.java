package org.example.lesson_5.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
//                    .addAnnotatedClass(Student.class)
//                    .buildSessionFactory();
        } else {
            return sessionFactory;
        }

    }

}
