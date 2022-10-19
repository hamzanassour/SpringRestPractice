package com.rest.controllers;

import com.rest.dao.StudentDao;
import com.rest.entities.GetStudentErrorResponse;
import com.rest.entities.Student;
import com.rest.exceptions.SomeThingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rest.exceptions.StudentNotFoundException;

import java.util.Date;
import java.util.List;

@RestController
public class MyFirstRestController {

    @Autowired
    StudentDao studentDao;

        @GetMapping(value="/students" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<List<Student>> getStudents() throws SomeThingException {
            if(1==1){
                throw new SomeThingException("just for testing");
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentDao.getAllStudents());
        }

        @GetMapping(value="/student/{id}" ,params ={"meth1"} ,produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
        public Student getStudentById(@PathVariable int id) throws StudentNotFoundException {
            if(studentDao.getAllStudents().size() < id){
                throw new  StudentNotFoundException("we can not find this student try with a < id ");
            }
            return studentDao.getStudentDataById(id);
        }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping(value="/student/{name}" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public Student getStudentByName(@PathVariable String name){
        System.out.println(name);
            return studentDao.getStudentDataByName(name);

    }
    // add a student with @RequestParam
    //@PostMapping("/student")
   // public List<Student> saveStudent(@RequestParam int id , @RequestParam String name , @RequestParam String cne , @RequestParam int level , @RequestParam String country){

      // Student s = new Student(id , name , cne , level , country);
       //     studentDao.saveStudent(s);
      //      return studentDao.getAllStudents();
   // }

    @PostMapping(value ="/student" ,produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE} , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> saveStudent(@RequestBody Student student ){
        System.out.println(student);
           studentDao.saveStudent(student);
           return studentDao.getAllStudents();
    }

    @ExceptionHandler
    public ResponseEntity<GetStudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
            System.out.println("exception handler");
            GetStudentErrorResponse response = new GetStudentErrorResponse();
            response.setDate(new Date());
            response.setErrorClass(studentNotFoundException.getClass().toString());
            response.setErrorMessage(studentNotFoundException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
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


}
