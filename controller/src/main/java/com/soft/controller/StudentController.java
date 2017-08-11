package com.soft.controller;

import com.soft.model.StudentModel;
import com.soft.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2017/8/7.
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Value("${test.msg}")
    private String msg;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String index() {
        return msg;
    }

    @ApiOperation(value = "查询所有记录.")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<StudentModel> findAll () {
        return studentService.findAll();
    }
}
