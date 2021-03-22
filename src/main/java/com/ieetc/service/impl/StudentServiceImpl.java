package com.ieetc.service.impl;

import com.ieetc.dao.StudentDao;
import com.ieetc.domain.Student;
import com.ieetc.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //引用类型自动注入@Autowired,或者@Resource
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int num = studentDao.insertStudent(student);
        return num;
    }

    @Override
    public List<Student> queryAllStudents() {
        return studentDao.selectStudents();
    }
}
