package com.wthink.car_producer2.dao;

import com.wthink.car_producer2.pojo.TbCar;
import com.wthink.car_producer2.pojo.TbCarExample;
import com.wthink.car_producer2.vo.TbCarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarMapper {
    int countByExample(TbCarExample example);

    int deleteByExample(TbCarExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCar record);

    int insertSelective(TbCar record);

    List<TbCar> selectByExample(TbCarExample example);

    TbCar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCar record, @Param("example") TbCarExample example);

    int updateByExample(@Param("record") TbCar record, @Param("example") TbCarExample example);

    int updateByPrimaryKeySelective(TbCar record);

    int updateByPrimaryKey(TbCar record);

    List<TbCarVo> queryCarList(TbCarVo tbCarVo);

    int delmore(String ids);

    //void delmore(int[] array);
}