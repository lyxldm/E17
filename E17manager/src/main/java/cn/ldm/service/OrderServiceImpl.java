package cn.ldm.service;

import cn.ldm.mapper.GoodsorderMapper;
import cn.ldm.pojo.Goodsorder;
import cn.ldm.pojo.GoodsorderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@Transactional
@RestController
public class OrderServiceImpl implements  OrderService{

    @Autowired
    GoodsorderMapper goodsorderMapper;


    @PostMapping("/order/add")
    @Override
    public void orderAdd(@RequestBody Goodsorder goodsorder) {

        goodsorderMapper.insert (goodsorder);
    }
}
