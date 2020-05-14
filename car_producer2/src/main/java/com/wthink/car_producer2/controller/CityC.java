package com.wthink.car_producer2.controller;

import com.wthink.car_producer2.pojo.City;
import com.wthink.car_producer2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/11 14:35
 */
@RestController
@RequestMapping("city")
public class CityC {
    @Autowired
    CityService cs;

    @RequestMapping("/queryByPid")
    public List<City> queryByPid(Integer pid){
        return cs.queryByPid(pid);
    }

}
