package cn.ldm.mapper;

import cn.ldm.pojo.Provice;

public interface ProviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Provice record);

    int insertSelective(Provice record);

    Provice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Provice record);

    int updateByPrimaryKey(Provice record);
}