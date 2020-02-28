package com.zty.project.service;


import com.zty.project.dao.UserDao;
import com.zty.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByUsername(Map map) {
        return userDao.findByUsername(map);
    }

    public User findUserById(User user) {
        return userDao.findUserById(user);
    }
}
