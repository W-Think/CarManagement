package com.wthink.car_cust.service;

import com.wthink.car_cust.dao.TbCarTypeMapper;
import com.wthink.car_cust.pojo.TbCarType;
import com.wthink.car_cust.pojo.TbCarTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/1 12:41
 */
@Service
public class TbCarTypeService {
    @Autowired
    private TbCarTypeMapper tctm;

    public List findCarType(int carPid) {
        return tctm.findCarType(carPid);
    }

    public List findTypes(int carPid) {
        return tctm.findTypes(carPid);
    }

    public List<TbCarType> queryTypeAll() {
        return tctm.selectByExample(new TbCarTypeExample());
    }

//    public List<TbCarType> queryByPid(int carPid) {
//        TbCarTypeExample tbCarTypeExample = new TbCarTypeExample();
//        tbCarTypeExample.createCriteria().andCarPidEqualTo(carPid);
//        return tctm.selectByExample(tbCarTypeExample);
//    }
}
