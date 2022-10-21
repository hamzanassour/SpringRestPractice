package com.rest.dao;

import com.rest.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Student> getAllStudents() {
        final String sql = "select * from student ";
        List<Student> students = jdbcTemplate.query (sql, new StudentMapper ());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        final String SQL_STUDENT_SELECT_SINGLE = "select * from student where id = ? ";
        Student student = jdbcTemplate.queryForObject (SQL_STUDENT_SELECT_SINGLE, new StudentMapper (), id);
        return student;
    }

    @Override
    public Student getStudentDataByName(String name) {
        final String SQL_STUDENT_SELECT_SINGLE = "select * from student where name = ? ";
        Student student = jdbcTemplate.queryForObject (SQL_STUDENT_SELECT_SINGLE, new StudentMapper (), name);
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        Student res = new Student ();
        final String sql = "insert into student values ( ? , ? , ? , ? , ?) " ;
        int update = jdbcTemplate.update (sql, student.getId (), student.getName (), student.getCne (), student.getLevel (), student.getCountry ());
        if (update == 1 ){
           res=  getStudentById (student.getId ());
        }
        return res;
    }
    @Override
    public Student updateStudent(Student student) {
        Student res = new Student ();
        final String sql = "update  student  set name = ? , cne = ? ,level = ? , country = ? where id = ? " ;
        int update = jdbcTemplate.update (sql,  student.getName (), student.getCne (), student.getLevel (), student.getCountry () , student.getId ());
        if (update == 1 ){
            res=  getStudentById (student.getId ());
        }
        return res;
    }

    @Override
    public void deleteStudent(int id) {
        final String sql = "delete  from student where id = ?" ;
        jdbcTemplate.update (sql, id);
    }

}
