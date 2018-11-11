package cn.ldm.service;

import cn.ldm.pojo.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "E17MANAGER")
public interface GoodsbarService {

    @PostMapping("/shopbar/add")
    public Boolean  add(@RequestParam("goods_id")Integer goods_id,@RequestParam("cust_id") Integer cust_id);


    @GetMapping("/priceTotal")
    public Map priceTotal(@RequestParam("cust_id")Integer cust_id);


    @GetMapping("/goodsbarList")
    public List<Item> goodsbarList(@RequestParam("cust_id") Integer cust_id);
}
