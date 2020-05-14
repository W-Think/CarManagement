package com.wthink.car_producer2.dao;

import com.wthink.car_producer2.pojo.TbCarUser;
import com.wthink.car_producer2.pojo.TbCarUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCarUserMapper {
    int countByExample(TbCarUserExample example);

    int deleteByExample(TbCarUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCarUser record);

    int insertSelective(TbCarUser record);

    List<TbCarUser> selectByExample(TbCarUserExample example);

    TbCarUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCarUser record, @Param("example") TbCarUserExample example);

    int updateByExample(@Param("record") TbCarUser record, @Param("example") TbCarUserExample example);

    int updateByPrimaryKeySelective(TbCarUser record);

    int updateByPrimaryKey(TbCarUser record);
}