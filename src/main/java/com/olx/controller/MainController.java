package com.olx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "redirect:/index.html";
    }

    @RequestMapping("/register")
    public String register(){
        return "redirect:/login.html";
    }


    @RequestMapping("/login")
    public String login(){
        return "redirect:/login.html";
    }


}
