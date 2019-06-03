package cn.ldm.controller;

import cn.ldm.mapper.ItemMapper;
import cn.ldm.pojo.Customer;
import cn.ldm.pojo.Item;
import cn.ldm.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/register")
    public void save(@RequestBody Customer customer){
        customerServiceImpl.save (customer);
    }

    @GetMapping("/login")/*为啥是post*/
    public String login(@RequestBody Customer customer){
        String token = customerServiceImpl.login (customer);
        if("error".equals (token)){
            return "error";
        }else{
            return token;
        }
    }


    /*@GetMapping("/isLose")
    public String idLose(String token){
        String customerinfo = customerServiceImpl.isLose (token);
        return customerinfo;
    }*/
}
