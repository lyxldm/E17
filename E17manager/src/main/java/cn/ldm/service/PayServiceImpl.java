package cn.ldm.service;

import cn.ldm.mapper.AddressMapper;
import cn.ldm.mapper.GoodsbarMapper;
import cn.ldm.mapper.GoodsorderMapper;
import cn.ldm.pojo.Address;
import cn.ldm.pojo.Goodsbar;
import cn.ldm.pojo.Goodsorder;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
@Transactional
@Controller
public class PayServiceImpl {
    @Autowired
    GoodsbarMapper goodsbarMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    GoodsorderMapper goodsorderMapper;

    @GetMapping("/clearbar")
    public String clearGoodsbar(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        Long orderid = Long.parseLong (out_trade_no);
        Goodsorder goodsorder = goodsorderMapper.selectByOrder (orderid);
        Address address = addressMapper.selectByPrimaryKey (goodsorder.getAddressId ());
        goodsbarMapper.deleteByCustid (address.getCustId ());
        goodsorderMapper.updateByPrimaryKey (goodsorder);
        return "redirect:http://114.116.26.76:9000/index.html";
    }
    /*@GetMapping("/clearbar1")
    public void  clearGoodsbar1(HttpServletRequest request,String out_trade_no) throws UnsupportedEncodingException, AlipayApiException {
        Long orderid = Long.parseLong (out_trade_no);
        Goodsorder goodsorder = goodsorderMapper.selectByOrder (orderid);
        Address address = addressMapper.selectByPrimaryKey (goodsorder.getAddressId ());
        goodsbarMapper.deleteByCustid (address.getCustId ());
        goodsorder.setStatus (1);
        goodsorderMapper.updateByPrimaryKey (goodsorder);
    }*/
}
