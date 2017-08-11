package com.soft.dao;

import com.soft.model.StudentModel;

import java.util.List;

/**
 * Created by admin on 2017/8/8.
 */
public interface StudentDao {

    public List<StudentModel> findAll();
}
