package com.ieetc.dao;

import com.ieetc.domain.Student;

import java.util.List;

public interface StudentDao {

    //增加学生
    int insertStudent(Student student);

    //查询所有学生
    List<Student> selectStudents();
}
