package com.wthink.car_producer2.service;

import com.wthink.car_producer2.dao.TbCarTypeMapper;
import com.wthink.car_producer2.pojo.TbCarType;
import com.wthink.car_producer2.pojo.TbCarTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> echartsShow() {
        //统计全部的类型
        List<TbCarType> tbCarTypes = tctm.selectByExample(new TbCarTypeExample());
        //统计类型一数量
        TbCarTypeExample bmwcarExample = new TbCarTypeExample();
        bmwcarExample.createCriteria().andCarPidEqualTo(1);
        List<TbCarType> bmwcarList = tctm.selectByExample(bmwcarExample);
        //统计类型二数量
        TbCarTypeExample hqcarExample = new TbCarTypeExample();
        hqcarExample.createCriteria().andCarPidEqualTo(9);
        List<TbCarType> hqcarList = tctm.selectByExample(hqcarExample);

        //数据的拼接
        Map<String, Object> map = new HashMap<>();
        map.put("carSize",tbCarTypes.size());
        map.put("bmwcar",bmwcarList.size());
        map.put("hqcar",hqcarList.size());
        return map;
    }
}
