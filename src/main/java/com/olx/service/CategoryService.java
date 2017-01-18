package com.olx.service;

import com.olx.model.Category;

import java.util.List;

public interface CategoryService {

    Category add(Category i);
    void delete(int id);
    Category edit(Category i);
    Category find(int id);
    List<Category> findAll();
}
