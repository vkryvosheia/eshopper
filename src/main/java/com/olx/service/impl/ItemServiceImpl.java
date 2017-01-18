package com.olx.service.impl;

import com.olx.dao.ItemDao;
import com.olx.model.Item;
import com.olx.service.ItemService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public Item add(Item i) {
        return itemDao.save(i);
    }

    @Override
    public void delete(int id) {
        itemDao.delete(id);
    }

    @Override
    public Item edit(Item i) {
        return itemDao.save(i);
    }

    @Override
    public Item edit(int id, String img) {
        Item i = itemDao.findOne(id);
        i.setImg(img);
        return itemDao.save(i);
    }

    @Override
    public Item find(int id) {
        return itemDao.findOne(id);
    }

    @Override
    public List<Item> findAll() {
        return itemDao.findAll();
    }

    @Override
    public List<Item> findByCategory(int id) {
        return itemDao.findByCategory(id);
    }
}
