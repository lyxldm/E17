package cn.ldm.mapper;

import cn.ldm.pojo.Goodsorder;

public interface GoodsorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodsorder record);

    int insertSelective(Goodsorder record);

    Goodsorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodsorder record);

    int updateByPrimaryKey(Goodsorder record);

    Goodsorder selectByOrder(Long orderId);
}