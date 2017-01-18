package com.olx.dao;

import com.olx.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer>{

    List<Item> findByCategory(int id);

}
