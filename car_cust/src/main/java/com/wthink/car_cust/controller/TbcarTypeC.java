package com.wthink.car_cust.controller;

import com.wthink.car_cust.service.TbCarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/4/30 13:49
 */
@Controller
@RequestMapping("carType")
public class TbcarTypeC {

    @Autowired
    private TbCarTypeService cts;

    /**
     * 查大商标
     * @param carPid
     * @return
     */
    @RequestMapping("/findCarType")
    @ResponseBody
    public List findCarType(@RequestParam("carPid")int carPid){
        System.out.println("22222222222222");
        List list = cts.findCarType(carPid);
        return list;
    }

    /**
     * 根据大商标查小商标
     * @param carPid
     * @return
     */
    @RequestMapping("/findTypes")
    @ResponseBody
    public List findTypes(@RequestParam("carPid")int carPid){
        System.out.println("33333333333333333");
        List list = cts.findTypes(carPid);
        return list;
    }
}
