package com.wthink.car_producer2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/13 17:17
 */
@Controller
public class IndexC {
    @RequestMapping("/")
    public String toLogin(){
        return  "index";
    }

    @RequestMapping("/toTest")
    public String toTest(){
        return "test";
    }
}
