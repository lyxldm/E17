package cn.ldm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Html {
    @RequestMapping("adjust_funding.html")
    private String a1(){
        return "adjust_funding";
    }
    @RequestMapping("discharge_statistic.html")
    private String a2(){
        return "discharge_statistic";
    }
    @RequestMapping("express_list.html")
    private String a3(){
        return "express_list";
    }
    @RequestMapping("index.html")
    private String a4(){
        return "index";
    }
    @RequestMapping("login.html")
    private String a5(){
        return "login";
    }
    @RequestMapping("order_detail.html")
    private String a6(){
        return "order_detail";
    }
    @RequestMapping("order_list.html")
    private String a7(){
        return "order_list";
    }
    @RequestMapping("pay_list.html")
    private String a8(){
        return "pay_list";
    }
    @RequestMapping("product_detail.html")
    private String a9(){
        return "product_detail";
    }
    @RequestMapping("product_list.html")
    private String a0(){
        return "product_list";
    }
    @RequestMapping("recycle_bin.html")
    private String a11(){
        return "recycle_bin";
    }
    @RequestMapping("sales_volume.html")
    private String a12(){
        return "sales_volume";
    }
    @RequestMapping("setting.html")
    private String a13(){
        return "setting";
    }
    @RequestMapping("user_detail.html")
    private String a14(){
        return "user_detail";
    }
    @RequestMapping("user_list.html")
    private String a15(){
        return "user_list";
    }
    @RequestMapping("user_rank.html")
    private String a16(){
        return "user_rank";
    }
}
