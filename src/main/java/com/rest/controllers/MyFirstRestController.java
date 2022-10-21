package com.rest.controllers;

import com.rest.dao.StudentDao;
import com.rest.entities.ExceptionResponse;
import com.rest.entities.Student;
import com.rest.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class MyFirstRestController {

    @Autowired
    StudentDao studentDao;


    // to get all the students
    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> allStudents = studentDao.getAllStudents ();
        return ResponseEntity.status (HttpStatus.ACCEPTED).body (allStudents);
    }

    // get a specific student by id
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student Student = studentDao.getStudentById (id);
        return ResponseEntity.status (HttpStatus.ACCEPTED).body (Student);
    }

    // get a specific student by name
    @GetMapping(value = "/students/{name}", params = {"h"})
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        Student Student = studentDao.getStudentDataByName (name);
        return ResponseEntity.status (HttpStatus.ACCEPTED).body (Student);
    }

    /*add a student with @RequestParam
     @PostMapping("/student")
     public List<Student> saveStudent(@RequestParam int id , @RequestParam String name , @RequestParam String cne , @RequestParam int level , @RequestParam String country){
     Student s = new Student(id , name , cne , level , country);
     studentDao.saveStudent(s);
     return studentDao.getAllStudents();
     }*/

    // add a student

    @PostMapping(value = "/students", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Student saveStudent(@RequestBody Student student) {
          Student student1 =  studentDao.saveStudent(student);
        return student1;
    }
    // update  a student
    @PutMapping(value = "/students", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Student updateStudent(@RequestBody Student student) {
        return studentDao.updateStudent(student);
    }
    // delete a student
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentDao.deleteStudent (id);
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
        System.out.println ("exception handler from controller ");
        ExceptionResponse response = new ExceptionResponse ();
        response.setDate (new Date ());
        response.setErrorClass (studentNotFoundException.getClass ().toString ());
        response.setErrorMessage (studentNotFoundException.getMessage ());
        return ResponseEntity.status (HttpStatus.NOT_FOUND).body (response);
    }

    /*

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler
    public GetStudentErrorResponse handleSomeThingException(SomeThingException someThingException){
    System.out.println("exception handler for someThingException");
    GetStudentErrorResponse response = new GetStudentErrorResponse();
    response.setDate(new Date());
    response.setErrorClass(someThingException.getClass().toString());
    response.setErrorMessage(someThingException.getMessage());
    return response;
    }
    */


}
