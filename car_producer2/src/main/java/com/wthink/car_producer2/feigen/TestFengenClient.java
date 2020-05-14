package com.wthink.car_producer2.feigen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/4/20 11:13
 */
@FeignClient(value = "BMWCARCUST")
public interface TestFengenClient {

    @RequestMapping("/carType/findCarType")
    List findCarType(@RequestParam("carPid")int carPid);

    @RequestMapping("/carType/findTypes")
    List findTypes(@RequestParam("carPid")int carPid);

}
