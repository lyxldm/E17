package cn.ldm.controller;

import cn.ldm.pojo.Item;
import cn.ldm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoadController {


    @Autowired
    ItemService itemService;
    @GetMapping("/recommend")
    @ResponseBody
    List<Item> list(){
        return itemService.listRecommend ();
    }
}
