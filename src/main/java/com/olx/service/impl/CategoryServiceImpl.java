package com.olx.service.impl;


import com.olx.dao.CategoryDao;
import com.olx.model.Category;
import com.olx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category add(Category i) {
        return categoryDao.save(i);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category edit(Category i) {
        return categoryDao.save(i);
    }

    @Override
    public Category find(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
