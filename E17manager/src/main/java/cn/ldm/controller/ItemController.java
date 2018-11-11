package cn.ldm.controller;

import cn.ldm.pojo.Item;
import cn.ldm.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ItemController {
    @Autowired
    ItemServiceImpl itemService;
    @PostMapping("/item")
    Integer add(@RequestBody Item item){
        Integer add = itemService.add (item);
        return  add;
    }


    @GetMapping("/recommend")
    List<Item> listRecommend(){
        List<Item> items = itemService.listRecommend ( );
        return items;
    }

    @GetMapping("/iteminfo")
    String iteminfo(Integer id,String callback){
        return itemService.iteminfo (id, callback);
    }
}
