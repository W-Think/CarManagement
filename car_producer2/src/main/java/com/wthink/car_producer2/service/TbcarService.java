package com.wthink.car_producer2.service;

import cn.hutool.core.bean.BeanUtil;
import com.wthink.car_producer2.dao.TbCarMapper;
import com.wthink.car_producer2.pojo.TbCar;
import com.wthink.car_producer2.vo.TbCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/4/30 13:49
 */
@Service
public class TbcarService {
    @Autowired
    TbCarMapper tcm;
//    public List<TbCarVo> queryCarList(TbCarVo tbCarVo,Integer current) {
//        List<TbCarVo> tbCarVoList=null;
//        if(current!=null){
//            PageHelper.startPage(current,6);
//            tbCarVoList=tcm.queryCarList(tbCarVo);
//        }else {
//            tbCarVoList=tcm.queryCarList(tbCarVo);
//        }
//        PageInfo pageInfo = new PageInfo(tbCarVoList);
//
//        List<TbCarVo> cars = tcm.queryCarList(tbCarVo);
//        return cars;
//    }

    public List<TbCarVo> queryCarList(TbCarVo tbCarVo) {
        List<TbCarVo> cars = tcm.queryCarList(tbCarVo);
        return cars;
    }

    @Transactional
    public Integer addCar(TbCar tbCar) {
//        tbCar.setId(StaticFlag.queryUUID());
//        tbCar.setCreateTime(new Date());
//        tbCar.setCarTypeId1(tbCarType.getId());
//        tbCar.setCarTypeId2(tbCarType.getCarPid());
        return tcm.insert(tbCar);
    }

    public TbCar queryByCarId(String id) {
        return tcm.selectByPrimaryKey(id);
    }

    @Transactional
    public Integer updateCar(TbCar tbCar) {
        return tcm.updateByPrimaryKey(tbCar);
    }

    public int delmore(String ids) {
        return tcm.delmore(ids);
    }

    @Transactional
    public void addAll(List<TbCarVo> all) {
        for (TbCarVo tbCarVo : all) {
            TbCar tbCar = new TbCar();
            //把CarVo这里面同名的字段 赋值到tCar的实体类中里面
            tbCar.setId(tbCarVo.getId());
            BeanUtil.copyProperties(tbCarVo,tbCar); //把前一个里面字段名相同的字段赋值到后面的那个实体类中
            tcm.insert(tbCar) ;
        }
    }

}
