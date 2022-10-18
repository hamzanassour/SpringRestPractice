package com.rest.dao;

import com.rest.entities.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    List<Student> students = new ArrayList<>();

    @PostConstruct
    public void setUpStudents(){
        System.out.println("we are creating objects");
        Student student1 = new Student(1, "hamza" , "W439005" , 5 , "Morocco");
        Student student2 = new Student(2,"ayoub" , "W439005" , 3 , "Morocco");
        Student student3 = new Student(3,"salma" , "W439005" , 4 , "India");
        Student student4 = new Student(4,"yasser" , "W439005" , 2 , "USA");
        Student student5 = new Student(5,"fatima" , "W439005" , 1 , "CANDA");
        this.students.add(student1);
        this.students.add(student2);
        this.students.add(student3);
        this.students.add(student4);
        this.students.add(student5);
    }

    @Override
    public List<Student> getAllStudents() {
        return  this.students;
    }

    @Override
    public Student getStudentDataById(int id) {
        return students.get(id-1);
    }

    @Override
    public Student getStudentDataByName(String name) {

        for (Student s : students){
            if (s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> saveStudent(Student student) {
        students.add(student);
        return students;
    }

}
