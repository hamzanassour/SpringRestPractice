package com.rest.dao;

import com.rest.entities.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student getStudentDataByName(String name);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(int id);
}
