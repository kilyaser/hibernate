package org.example.lesson_5.repository;


import org.example.lesson_5.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAO implements CRUDRepository<Student, Long> {

    private final SessionFactory sessionFactory;

    public StudentDAO() {
        this.sessionFactory = SessionFactoryUtils.getSessionFactory();
    }
    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }
    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student studentDB = session.get(Student.class, id);
        session.remove(studentDB);
        session.getTransaction().commit();
    }
    @Override
    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(student);
    }
    @Override
    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student studentDB = session.get(Student.class, id);
        session.getTransaction().commit();
        return studentDB;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        session.getTransaction().commit();
        return students;
    }
}
