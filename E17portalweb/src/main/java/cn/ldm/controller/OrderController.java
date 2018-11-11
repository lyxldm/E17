package cn.ldm.controller;

import cn.ldm.mapper.GoodsbarMapper;
import cn.ldm.mapper.GoodsorderMapper;
import cn.ldm.pojo.Goodsorder;
import cn.ldm.pojo.GoodsorderParam;
import cn.ldm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/order/add")
    public void orderAdd(GoodsorderParam goodsorderParam){
        String order = goodsorderParam.getOrder ( );
        long order1 = Long.parseLong (order);
        Goodsorder goodsorder = new Goodsorder ();
        goodsorder.setAddressId (goodsorderParam.getAddressId ());
        goodsorder.setOrderid (order1);
        goodsorder.setPrice (goodsorderParam.getPrice ());
        /*0未支付，1支付*/
        goodsorder.setStatus (0);
        orderService.orderAdd (goodsorder);
    }
}
