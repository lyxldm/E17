package cn.ldm.controller;

        import cn.ldm.AppPW;
        import cn.ldm.pojo.Address;
        import cn.ldm.pojo.Customer;
        import cn.ldm.pojo.Page;
        import cn.ldm.service.CustomerService;
        import cn.ldm.utills.CookieUtils;
        import cn.ldm.utills.CustomerinfoUtils;
        import com.alibaba.fastjson.JSON;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpRequest;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/register")
    public String save(Customer customer){
        try {
            customerService.save (customer);
            return "login";
        } catch (Exception e) {
            e.printStackTrace ( );
            return "error";
        }
    }


    @GetMapping("/login")
    public String login(Customer customer, HttpServletRequest request, HttpServletResponse response, Model model){
        String token = CookieUtils.getCookieValue (request, "token");
        if(token != null){
            String customerinfo = customerService.isLose (token);
            if("error".equals (customerinfo)){
                String token1 = customerService.login (customer);
                if("false".equals (token1)){
                    return "login";
                }else{
                    CookieUtils.setCookie (request,response,"token",token1);
                    return "index";
                }
            }else{
                return "index";
            }
        }else{
            String token1 = customerService.login (customer);
            if("false".equals (token1)){
                return "login";
            }else{

                /*开发环境写入cookie问题*/

                Cookie cookie = new Cookie("token", token1);// 创建一个cookie，cookie的名字是key
                cookie.setDomain(request.getServerName());
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
                return "index";
            }
        }
    }

    @GetMapping("/customerinfo")
    @ResponseBody
    public String customerinfo(HttpServletRequest request){
        String cookievalue = CookieUtils.getCookieValue (request, "token");
        String customerinfo = customerService.isLose (cookievalue);
        return customerinfo;
    }


    @PostMapping("/address/add")
    public String saveAddress(Address address){
        Boolean b = customerService.saveAddress (address);
        return "redirect:/vip.html";
    }

    @GetMapping("/addressList")
    @ResponseBody
    public Page addressList(HttpServletRequest request,Integer page,Integer rows){
        String cookieValue = CookieUtils.getCookieValue (request, "token");
        String customerinfo = customerService.isLose (cookieValue);
        Customer customer = JSON.parseObject (customerinfo,Customer.class);
        Page page1 = customerService.addressList (customer.getId ( ), page, rows);
        return page1;
    }


    @GetMapping("/orderAddressList")
    @ResponseBody
    public List<Address> orderAddressList(HttpServletRequest request){
        Customer customer = CustomerinfoUtils.GetCustomerInfo (request, customerService);
        List<Address> addresses = customerService.orderAddressList (customer.getId ( ));
        return addresses;
    }


}
