package com.soft.service;

import com.soft.dao.UserDao;
import com.soft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/7.
 */
@Service("indexService")
public class IndexService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll () {
        List<User> list = userDao.findAll();
        User.printList(list);

        return list;
    }

}
