package com.example.hibernate.dao;

import com.example.hibernate.entity.Student;

import java.util.List;

public interface studentDAO {

    void save(Student thestudent);

    Student findbyid(Integer id);
    List<Student> findall();
    List<Student> findbylast(String lastname);

    void update(Student thest);

    void deletest(Integer id);
}
