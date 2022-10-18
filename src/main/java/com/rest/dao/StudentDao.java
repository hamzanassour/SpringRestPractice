package com.rest.dao;

import com.rest.entities.Student;

import java.util.List;

public interface StudentDao {

    List<Student>  getAllStudents();
    Student getStudentDataById(int id);
    Student getStudentDataByName(String name);
    List<Student> saveStudent(Student student);
}
