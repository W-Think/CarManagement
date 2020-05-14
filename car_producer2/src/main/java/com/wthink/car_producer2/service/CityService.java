package com.wthink.car_producer2.service;

import com.wthink.car_producer2.dao.CityMapper;
import com.wthink.car_producer2.pojo.City;
import com.wthink.car_producer2.pojo.CityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/9 8:59
 */
@Service
public class CityService {
    @Autowired
    private CityMapper cm;

    public List<City> queryByPid(Integer pid) {
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andPidEqualTo(pid);
        return cm.selectByExample(cityExample);
    }
}
