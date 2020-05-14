package com.wthink.car_cust.dao;

import com.wthink.car_cust.pojo.TbCarType;
import com.wthink.car_cust.pojo.TbCarTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarTypeMapper {
    int countByExample(TbCarTypeExample example);

    int deleteByExample(TbCarTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCarType record);

    int insertSelective(TbCarType record);

    List<TbCarType> selectByExample(TbCarTypeExample example);

    TbCarType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCarType record, @Param("example") TbCarTypeExample example);

    int updateByExample(@Param("record") TbCarType record, @Param("example") TbCarTypeExample example);

    int updateByPrimaryKeySelective(TbCarType record);

    int updateByPrimaryKey(TbCarType record);

    List findCarType(int carPid);

    List findTypes(int carPid);
}