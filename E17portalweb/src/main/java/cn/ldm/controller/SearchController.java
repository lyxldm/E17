package cn.ldm.controller;

import cn.ldm.pojo.Item;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class SearchController {
    @Value("${SEARCH_URL}")
    String searchUrl;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("search")
    public String search(String searchText, Model model){
        List<Item> list = restTemplate.postForObject (searchUrl + "search",searchText, List.class);
        model.addAttribute ("list",list);
        return "search";
    }




    @GetMapping("search1")
    public String search1(Model model){
        List<Item> list = restTemplate.getForObject (searchUrl + "search", List.class);
        model.addAttribute ("list",list);
        return "1";
    }



}
