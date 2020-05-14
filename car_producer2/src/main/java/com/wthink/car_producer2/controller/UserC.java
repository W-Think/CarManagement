package com.wthink.car_producer2.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.wthink.car_producer2.pojo.TbCarUser;
import com.wthink.car_producer2.service.UserService;
import com.wthink.car_producer2.until.StaticFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/13 19:58
 */
@Controller
@RequestMapping("/user")
public class UserC {
    @Autowired
    UserService us;

    @RequestMapping("/toRegister")
    public String  toRegister(){
        return "register";
    }

    /**
     * 注册功能
     * @return
     */
    @RequestMapping("/registerToUser")
    public String registerToUser(TbCarUser tbCarUser){
        if(null!=tbCarUser){
            tbCarUser.setId(RandomUtil.randomUUID().replace("-","")); //设置主键的id
            tbCarUser.setCreateTime(new Date()); //设置添加的时间
            String md5Pwd = SecureUtil.md5(tbCarUser.getPwd());//密码md5 加密
            tbCarUser.setPwd(md5Pwd);
        }
        int flag = us.registerToUser(tbCarUser);
        return flag>0?"index":"register"; //三目判断
    }

    @RequestMapping("/checkPhone")
    @ResponseBody
    public Map<String,String> checkPhone(String phone){
        String msg =us.checkPhone(phone);
        Map<String,String> map =new HashMap<>();
        map.put("msg",msg);
        return map;
    }

    /**
     * 登录的效验
     */
    @RequestMapping(value = "/checkPwdAndUserName",method = RequestMethod.POST)
    public String checkPwdAndUserName(String loginName, String pwd, Model model, HttpServletRequest request){
        if(!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(pwd)){
            TbCarUser tbCarUser =  us.checkPwdAndUserName(loginName,pwd);
            if (null==tbCarUser){ //用户名或者密码错误
                model.addAttribute("msg","用户名或者密码错误");
                return "index";
            }else{
                //放入session
                request.getSession().setAttribute(StaticFlag.USERINFO,tbCarUser);
                model.addAttribute("msg"," ");
                //返回到列表页面
                return "redirect:/bmw/queryCarList" ;
            }
        }else{
            model.addAttribute("msg","用户名密码不能为空");
            //如果用户名或者密码为空，则返回到登录页面
            return "index";
        }
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping("/removeSessionToLogin")
    public String removeSessionToLogin(HttpServletRequest request){
        request.getSession().removeAttribute(StaticFlag.USERINFO);
        return "index";
    }
}
