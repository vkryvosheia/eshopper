package com.olx.service;


import com.olx.model.Item;


import java.util.List;

public interface ItemService {

    Item add(Item i);
    void delete(int id);
    Item edit(Item i);
    Item edit(int id, String img);
    Item find(int id);
    List<Item> findAll();
    List<Item> findByCategory(int id);
}
