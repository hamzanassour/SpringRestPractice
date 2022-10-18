package com.rest.controllers;

import com.rest.dao.StudentDao;
import com.rest.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyFirstRestController {

    @Autowired
    StudentDao studentDao;

        @GetMapping(value="/students" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
        public List<Student> getStudents(){
            return studentDao.getAllStudents();
        }

        @GetMapping(value="/student/{id}" ,params ={"meth1"} ,produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
        public Student getStudentById(@PathVariable int id){
            return studentDao.getStudentDataById(id);
        }
    @GetMapping(value="/student/{name}" ,params ={"meth2"} , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public Student getStudentByName(@PathVariable String name){
        System.out.println(name);
            return studentDao.getStudentDataByName(name);

    }
    @PostMapping("/student")
    public List<Student> saveStudent(@RequestParam int id , @RequestParam String name , @RequestParam String cne , @RequestParam int level , @RequestParam String country){

       Student s = new Student(id , name , cne , level , country);
            studentDao.saveStudent(s);
            return studentDao.getAllStudents();
    }


}
