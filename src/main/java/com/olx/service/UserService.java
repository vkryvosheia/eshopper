package com.olx.service;


import com.olx.model.User;

import java.util.List;

public interface UserService {

    User add(User u);
    void delete(int id);
    User edit(User u);
    User find(int id);
    List<User> findAll();
    User findByUsername(String username);
}
