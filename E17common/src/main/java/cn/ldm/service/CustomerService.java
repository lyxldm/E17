package cn.ldm.service;

import cn.ldm.pojo.Address;
import cn.ldm.pojo.Customer;
import cn.ldm.pojo.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "E17SSO")
public interface CustomerService {
    @PostMapping("/register")
    public void save(Customer customer);

    @GetMapping("/login")
    public String login(Customer customer);

    @GetMapping("/isLose")
    public String isLose(@RequestParam("token") String token);

    @PostMapping("/address/add")
    public Boolean saveAddress(Address address);

    @GetMapping("/addressList")
    public Page addressList(@RequestParam("id") Integer id, @RequestParam("page")Integer page, @RequestParam("rows")Integer rows);

    @GetMapping("/orderAddressList")
    public List<Address> orderAddressList(@RequestParam("cust_id") Integer cust_id);

}
