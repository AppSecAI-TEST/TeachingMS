package com.soft.dao;

import com.soft.model.User;

import java.util.List;

/**
 * Created by admin on 2017/8/8.
 */
public interface UserDao {

    public List<User> findAll();
}
