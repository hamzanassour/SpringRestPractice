package com.rest.dao;

import com.rest.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt (1);
        String name = rs.getString (2);
        String cne = rs.getString (3);
        int level = rs.getInt (4);
        String country = rs.getString (5);
        Student student = new Student (id, name, cne, level, country);
        return student;
    }
}
