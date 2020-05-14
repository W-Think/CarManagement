package com.wthink.car_producer2.controller;

import com.wthink.car_producer2.service.TbCarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/11 16:46
 */
@Controller
@RequestMapping("/cartype")
public class CarTypeC {
    @Autowired
    private TbCarTypeService cts;

    /**
     * 生成柱状图
     * @return
     */
    @RequestMapping("/toShow")
    public String toTest(){
        return "car_show";
    }
    @RequestMapping("/echartsShow")
    @ResponseBody
    public Map<String,Object> echartsShow(){
        Map<String,Object> map = new HashMap<>();
        map = cts.echartsShow();
        return map;
    }
}
