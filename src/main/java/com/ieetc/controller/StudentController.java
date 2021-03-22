package com.ieetc.controller;

import com.ieetc.domain.Student;
import com.ieetc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService service;

    //学生注册
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        //调用service处理student
        int num = service.addStudent(student);
        if (num > 0){
            tips = "学生【" + student.getName() + "】注册成功";
        }
        //添加数据
        mv.addObject("tips", tips);
        //指定结果页面
        mv.setViewName("result");
        return mv;
    }

    //查询所有学生
    @RequestMapping("queryStudents.do")
    @ResponseBody
    public List<Student> queryAllStudents(){
        List<Student> list = service.queryAllStudents();
        return list;
    }
}
