package com.olx.controller;

import com.olx.model.Item;
import com.olx.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    public static String statImg;
    @RequestMapping(value = "/add_item", method = RequestMethod.POST)
    public @ResponseBody
    Item uploadFileHandler(@RequestParam("nameOfPic") String nameOfPic, @RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam("price") double price, @RequestParam("category") int category) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                File dir = new File(System.getProperty("user.dir") + "/src/main/webapp/images/" + File.separator);
                if (!dir.exists())
                    dir.mkdirs();

                List<Item> list = itemService.findAll();

                String nameRes = null;
                System.out.println("name is: " + nameOfPic);
                for (int i = 0; i < list.size(); i++) {
                    if (nameOfPic.equals(list.get(i).getImg())) {
                        String name2 = nameOfPic.substring(0, nameOfPic.indexOf('.'));
                        String name3 = nameOfPic.substring(nameOfPic.indexOf('.'), nameOfPic.length());
                        nameOfPic = name2 + "(" + list.get(i).getId() + ")" + name3;
                        System.out.println(nameOfPic);
                    }
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + nameOfPic);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                ItemController.statImg = serverFile.getAbsolutePath();

                Item i = new Item(name, price, category, nameOfPic);

                itemService.add(i);
                return i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
        return null;
    }


    @RequestMapping("/find_by_category/{id}")
    @ResponseBody
    public List<Item> findByCategory(@PathVariable int id){
        List<Item> list = itemService.findByCategory(id);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }


    @RequestMapping("/items")
    @ResponseBody
    public List<Item> findAll(){
        return itemService.findAll();
    }



}
