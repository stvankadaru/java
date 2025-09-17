package com.gl.dao;


import java.util.List;

import com.gl.model.Student;

public interface StudentDao {
    void save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    void update(Student student);
    void delete(Long id);
}