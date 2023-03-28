package org.example;

import org.example.lesson_5.entity.Student;
import org.example.lesson_5.repository.StudentDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        for (int i = 1; i < 1000; i++) {
            Student student = new Student("Student" + i, "A");
            studentDAO.save(student);
        }
        List<Student> students = studentDAO.findAll();
        System.out.println(students.size());
        studentDAO.deleteById(100L);
        System.out.println(students.size());

        Student studentDB = studentDAO.findById(10L);
        System.out.println(studentDB);
        studentDB.setName("Uniq");
        studentDB.setMark("F");
        System.out.println(studentDB);
        studentDAO.deleteById(10L);



    }
}