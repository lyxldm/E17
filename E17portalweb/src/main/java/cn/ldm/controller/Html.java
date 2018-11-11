package cn.ldm.controller;

import cn.ldm.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Html {
    @GetMapping("/a")
    String index1(){
        return "1";
    }

    @GetMapping("/search.html")
    public String aa(){
        return "search";
    }
    @GetMapping("/")
    String index(){
        return "login";
    }
    @RequestMapping("/order.html")
    String a1(){
        return "order";
    }
    @RequestMapping("/about.html")
    String a2(){
        return "about";
    }
    @RequestMapping("/biaoge.html")
    String a3(){
        return "biaoge";
    }
    @RequestMapping("/contact.html")
    String a4(){
        return "contact";
    }
    @RequestMapping("/help.html")
    String a5(){
        return "help";
    }
    @RequestMapping("/index.html")
    String a6(){
        return "index";
    }
    @RequestMapping("/login.html")
    String a7(){
        return "login";
    }
    @RequestMapping("/message.html")
    String a8(){
        return "message";
    }
    @RequestMapping("/order2.html")
    String a9(){
        return "order2";
    }
    @RequestMapping("/orderDetails.html")
    String a10(){
        return "orderDetails";
    }
    @RequestMapping("/product.html")
    String a11(){
        return "product";
    }
    @RequestMapping("/proinfo.html")
    String a12(){
        return "proinfo";
    }
    @RequestMapping("/reg.html")
    String a13(){
        return "reg";
    }
    @RequestMapping("/success.html")
    String a14(){
        return "success";
    }
    @RequestMapping("/vip.html")
    String a15(){
        return "vip";
    } @RequestMapping("/vipAdress.html")
    String a16(){
        return "vipAdress";
    }
    @RequestMapping("/vipExit.html")
    String a17(){
        return "vipExit";
    }
    @RequestMapping("/vipMy.html")
    String a18(){
        return "vipMy";
    }
    @RequestMapping("/vipOrder.html")
    String a19(){
        return "vipOrder";
    }
    @RequestMapping("/vipPwd.html")
    String a20(){
        return "vipPwd";
    }
    @RequestMapping("/vipTuihuo.html")
    String a21(){
        return "vipTuihuo";
    }





}
