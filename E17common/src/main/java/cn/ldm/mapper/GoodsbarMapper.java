package cn.ldm.mapper;

import cn.ldm.pojo.Goodsbar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsbarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodsbar record);

    int insertSelective(Goodsbar record);

    Goodsbar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodsbar record);

    int updateByPrimaryKey(Goodsbar record);

    Goodsbar isExist(@Param("goodsid") Integer goodsid, @Param ("custid") Integer custid);

    List<Goodsbar> priceTotal(@Param ("cust_id")Integer cust_id);

    void deleteByCustid(@Param ("cust_id")Integer cust_id);

}