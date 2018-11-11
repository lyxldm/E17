package cn.ldm.service;

import cn.ldm.mapper.ItemMapper;
import cn.ldm.pojo.Item;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Transactional
@RestController
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemMapper itemMapper;

    @PostMapping("/item")
    @Override
    public Integer add(@RequestBody Item item) {
        itemMapper.insert (item);
        return item.getId ();
    }

    @GetMapping("/recommend")
    @Override
    public List<Item> listRecommend() {
        PageHelper.startPage (1,5);
        List<Item> items = itemMapper.listRecommend ( );
        for(Item item:items){
            String substring = StringUtils.substring (item.getImg (), 0, 73);
            item.setImg (substring);
        }
        return items;
    }

    @GetMapping("/iteminfo")
    @Override
    public String iteminfo(Integer id,String callback) {
        Item item = itemMapper.selectByPrimaryKey (id);
        //String img = item.getImg ();
        //String[] img1 = img.split (",");
        //Item1 item1 = new Item1 (item.getId ( ), item.getTitle ( ), img1, item.getPrice ( ), item.getNumber ( ), item.getSize ( ), item.getDes ( ), item.getStatus ( ));
        String s = JSON.toJSONString (item);
        //System.out.println (s );
        return callback+"("+s+");";
    }
}
