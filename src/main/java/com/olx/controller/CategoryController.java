package com.olx.controller;

import com.olx.model.Category;
import com.olx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    @ResponseBody
    public List<Category>getAll(){
        return categoryService.findAll();
    }

//    @RequestMapping("/categories_names")
//    @ResponseBody
//    public List<Cate>


}
