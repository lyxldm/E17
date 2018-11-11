package com.alipay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class html {
    @GetMapping("/index.html")
    public String a1(){
        return "index";
    }
}
