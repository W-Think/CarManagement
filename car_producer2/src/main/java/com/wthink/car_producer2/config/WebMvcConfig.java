package com.wthink.car_producer2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/6 20:09
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //登录同时配置资源的拦截器
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    //资源的过滤及配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/"); //请求的地址(跳转到登录)
        list.add("/user/checkPwdAndUserName"); //请求的地址（登录的校验）
        list.add("/user/checkPhone"); //请求的地址（登录的校验）
        list.add("/user/toRegister"); //注册成功
        list.add("/user/sendPhone"); //验证码
        list.add("/user/checkCodePhone"); //验证码
        list.add("/user/registerToUser"); //注册成功
        list.add("/bmw/toAdd"); //注册成功

        list.add("/static/css/**"); //请求的地址
        list.add("/static/js/**"); //请求的地址
        list.add("/static/img/**"); //请求的地址
        list.add("/static/bootstrap-datetimepicker/**"); //请求的地址
        /*    addPathPatterns  /** 代表拦截所有  拦截的规则
        excludePathPatterns 配置不拦截的规则 */
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
    }
}
