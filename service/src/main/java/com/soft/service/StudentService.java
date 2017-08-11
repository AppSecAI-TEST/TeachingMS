package com.soft.service;

import com.soft.dao.StudentDao;
import com.soft.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/8/7.
 */
@Service("studentService")
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<StudentModel> findAll () {
        List<StudentModel> list = studentDao.findAll();
        return list;
    }

}
