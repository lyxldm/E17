package cn.ldm.controller;

import cn.ldm.pojo.Customer;
import cn.ldm.pojo.Item;
import cn.ldm.service.CustomerService;
import cn.ldm.service.GoodsbarService;
import cn.ldm.utills.CookieUtils;
import cn.ldm.utills.CustomerinfoUtils;
import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController
{
    @Autowired
    GoodsbarService goodsbarService;
    @Autowired
    CustomerService customerService;

    @PostMapping("/shopbar/add")
    @ResponseBody
    public String goodsadd(HttpServletRequest request,Integer id){
        String cookieValue = CookieUtils.getCookieValue (request, "token");
        String customerinfo = customerService.isLose (cookieValue);
        Customer customer = JSON.parseObject (customerinfo,Customer.class);
        try {
            goodsbarService.add (id,customer.getId ());
            return "加入购物车成功";
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return "加入购物车失败";
    }


    @GetMapping("/priceTotal")
    @ResponseBody
    public Map priceTotal(HttpServletRequest request){
        Customer customer = CustomerinfoUtils.GetCustomerInfo (request, customerService);
        Map map = goodsbarService.priceTotal (customer.getId ( ));
        return map;
    }


    @GetMapping("/goodsbarList")
    @ResponseBody
    public List<Item> goodsbarList(HttpServletRequest request){
        Customer customer = CustomerinfoUtils.GetCustomerInfo (request, customerService);
        List<Item> items = goodsbarService.goodsbarList (customer.getId ( ));
        return items;
    }

}
