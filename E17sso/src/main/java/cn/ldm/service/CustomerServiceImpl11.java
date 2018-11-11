package cn.ldm.service;

import cn.ldm.mapper.AddressMapper;
import cn.ldm.mapper.CustomerMapper;
import cn.ldm.pojo.Address;
import cn.ldm.pojo.Customer;
import cn.ldm.pojo.Page;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CustomerServiceImpl11 implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @PostMapping("/register")
    @Override
    public void save(@RequestBody Customer customer) {
        customerMapper.insert (customer);
    }

    @GetMapping("/login")
    @Override
    public String login(@RequestBody Customer customer) {
        Customer login = customerMapper.login (customer.getUsername ( ));
        if(login.getPassword ().equals (customer.getPassword ())){
            String token = null;
            try {
                token = UUID.randomUUID ( ).toString ();
                String customer1 = JSON.toJSONString (login);
                stringRedisTemplate.opsForValue ().set ("sessionid:"+token,customer1,1800, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace ( );
            }
            return token;
        }else{
            return "false";
        }
    }

    @GetMapping("/isLose")
    @Override
    public String isLose(String token) {
        String customerinfo = stringRedisTemplate.opsForValue ( ).get ("sessionid:" + token);
        if(customerinfo != null){
            stringRedisTemplate.opsForValue ().set ("sessionid:"+token,customerinfo,1800, TimeUnit.SECONDS);
            return customerinfo;
        }
        return "error";
    }

    @PostMapping("/address/add")
    @Override
    public Boolean saveAddress(@RequestBody Address address) {
        try {
            addressMapper.insert (address);
            return true;
        } catch (Exception e) {
            e.printStackTrace ( );
            return false;
        }
    }

    @GetMapping("/addressList")
    @Override
    public Page addressList(Integer id,Integer page,Integer rows) {
        PageHelper.startPage (page,rows);
        List<Address> addresses = addressMapper.addressList (id);
        PageInfo pageInfo = new PageInfo (addresses);
        Page page1 = new Page ();
        Long total = pageInfo.getTotal ( );
        page1.setTotal (total);
        page1.setRows (addresses);
        return page1;
    }


    @GetMapping("/orderAddressList")
    @Override
    public List<Address> orderAddressList(Integer cust_id) {
        return addressMapper.addressList (cust_id);
    }
}
