package com.olx.controller;

import com.olx.model.User;
import com.olx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "register_user", method = RequestMethod.POST)
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password){

        if(username!=null && password!=null){

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.add(user);
        }

        return "added successfully";
    }
}
