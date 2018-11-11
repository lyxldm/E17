package cn.ldm.service;

import cn.ldm.mapper.GoodsbarMapper;
import cn.ldm.mapper.ItemMapper;
import cn.ldm.pojo.Goodsbar;
import cn.ldm.pojo.Item;
import cn.ldm.utills.CustomerinfoUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RestController
public class GoodsbarServiceImpl implements GoodsbarService{
    @Autowired
    GoodsbarMapper goodsbarMapper;

    @PostMapping("/shopbar/add")
    @Override
    public Boolean add(Integer goods_id, Integer cust_id) {
        Goodsbar exist = goodsbarMapper.isExist (goods_id,cust_id);
        try {
            if(exist != null){
                exist.setNumber (exist.getNumber ()+1);
                goodsbarMapper.updateByPrimaryKey (exist);
            }else{
                Goodsbar goodsbar = new Goodsbar ();
                goodsbar.setNumber (1);
                goodsbar.setCustId (cust_id);
                goodsbar.setGoodsId (goods_id);
                goodsbarMapper.insert (goodsbar);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return  false;
    }


    @Autowired
    ItemMapper itemMapper;
    @GetMapping("/priceTotal")
    @Override
    public Map priceTotal(Integer cust_id) {
        Integer priceTotal = 0;
        Integer totalNumber = 0;
        List<Goodsbar> goodsbars = goodsbarMapper.priceTotal (cust_id);
        for(Goodsbar goodsbar:goodsbars){
            Integer onePrice= itemMapper.oneOrice (goodsbar.getGoodsId ( ));
            priceTotal += onePrice * goodsbar.getNumber ();
            totalNumber += goodsbar.getNumber ();
        }
        Map map = new HashMap ();
        map.put ("priceTotal",priceTotal);
        map.put ("totalNumber",totalNumber);
        return map;
    }


    @GetMapping("/goodsbarList")
    @Override
    public List<Item> goodsbarList(Integer cust_id) {
        /*PageHelper.startPage (1,5);*/
        List<Item> list = new ArrayList<> ();
        List<Goodsbar> goodsbars = goodsbarMapper.priceTotal (cust_id);
        for(Goodsbar goodsbar:goodsbars){
            Item item = itemMapper.selectByPrimaryKey (goodsbar.getGoodsId ( ));
            item.setNumber (goodsbar.getNumber ());
            String substring = StringUtils.substring (item.getImg (), 0, 73);
            item.setImg (substring);
            list.add (item);
        }
        return list;
    }


}
