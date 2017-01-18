package com.olx.service.impl;


import com.olx.dao.RoleDao;
import com.olx.dao.UserDao;
import com.olx.model.Role;
import com.olx.model.User;
import com.olx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Override
    public User add(User u) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        u.setRoles(roles);
        return userDao.save(u);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
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
