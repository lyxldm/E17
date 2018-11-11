package cn.ldm.service;

import cn.ldm.pojo.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "E17MANAGER")
public interface ItemService {
    @PostMapping("/item")
    Integer add(Item item);

    @GetMapping("/recommend")
    List<Item> listRecommend();

    @GetMapping("/iteminfo")
    String iteminfo(@RequestParam("id")Integer id,@RequestParam("callback")String callback);
}
