package com.olx.service.impl;


import com.olx.dao.UserDao;
import com.olx.model.User;
import com.olx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User add(User u) {
        return userDao.save(u);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User edit(User u) {
        return userDao.save(u);
    }

    @Override
    public User find(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
