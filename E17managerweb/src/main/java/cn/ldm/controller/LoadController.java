package cn.ldm.controller;

import cn.ldm.pojo.Item;
import cn.ldm.service.ItemService;
import cn.ldm.utills.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoadController {
    @Value("${SEARCH_URL}")
    String searchUrl;
    @Value ("${IMAGE_SERVER}")
    String basepath;
    @Autowired
    RestTemplate restTemplate;
    @PostMapping("/img")
    @ResponseBody
    public Map addFile(MultipartFile file) throws Exception {
        Map map = new HashMap<> ();
        String filename = file.getOriginalFilename ();
        String ext = filename.substring (filename.lastIndexOf (".")+1);
        FastDFSClient fastDFSClient = new  FastDFSClient("classpath:fdfs.conf");
        String s = fastDFSClient.uploadFile (file.getBytes (),ext);
        if(s.isEmpty ()){
            map.put ("error",1);
            map.put ("message","上传错误");
            return map;
        }else{
            map.put ("error",0);
            map.put ("url",basepath+s);
            return map;
        }
    }

    @GetMapping("/")
    public String add(){
        return "add";
    }

    @Autowired
    ItemService itemService;
    @PostMapping("/item")
    String add(Item item){
        Integer add = itemService.add (item);
        item.setId (add);
        restTemplate.postForObject (searchUrl + "search/add", item, Boolean.class);
        return "success";
    }

}
