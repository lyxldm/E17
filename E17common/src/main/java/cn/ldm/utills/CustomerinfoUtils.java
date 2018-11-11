package cn.ldm.utills;

import cn.ldm.pojo.Customer;
import cn.ldm.service.CustomerService;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;

public class CustomerinfoUtils {
    public static Customer GetCustomerInfo(HttpServletRequest request, CustomerService customerService){
        String cookieValue = CookieUtils.getCookieValue (request, "token");
        String customerinfo = customerService.isLose (cookieValue);
        Customer customer = JSON.parseObject (customerinfo,Customer.class);
        return customer;
    }
}
