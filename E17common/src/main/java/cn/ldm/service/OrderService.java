package cn.ldm.service;

import cn.ldm.pojo.Goodsorder;
import cn.ldm.pojo.GoodsorderParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "E17MANAGER")
public interface OrderService {

    @PostMapping("/order/add")
    public void orderAdd(Goodsorder goodsorder);

}
