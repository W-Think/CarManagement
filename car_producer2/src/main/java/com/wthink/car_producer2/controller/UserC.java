package com.wthink.car_producer2.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.mail.MailUtil;
import com.wthink.car_producer2.pojo.TbCarUser;
import com.wthink.car_producer2.service.UserService;
import com.wthink.car_producer2.utils.StaticFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/13 19:58
 */
@Controller
@RequestMapping("/user")
public class UserC {
    @Autowired
    private UserService us;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/toRegister")
    public String  toRegister(){
        return "register";
    }

    /**
     * 注册功能
     * @return
     */
    @RequestMapping("/registerToUser")
    public String registerToUser(TbCarUser tbCarUser, Model model){
        if(null!=tbCarUser){
            tbCarUser.setId(RandomUtil.randomUUID().replace("-","")); //设置主键的id
            tbCarUser.setCreateTime(new Date()); //设置添加的时间
            String md5Pwd = SecureUtil.md5(tbCarUser.getPwd());//密码md5 加密
            tbCarUser.setPwd(md5Pwd);
        }
        int flag = us.registerToUser(tbCarUser);
        if (flag>0){
            sendEmail(tbCarUser);
            return "index";
        }else {
            model.addAttribute("msg","失败");
            return "register";
        }
        //return flag>0?"index":"register"; //三目判断
    }

    /**
     * 发送邮箱验证信息
     * @param tbCarUser
     */
    @RequestMapping("/sendEmail")
    public void sendEmail(TbCarUser tbCarUser){
        String content = "<h1>欢迎您"+tbCarUser.getLoginName()+"注册成功</h1>";
        MailUtil.send(tbCarUser.getEmail(),"你好",content,true);
    }

    /**
     * 模拟，发送短信验证码
     */
    @RequestMapping("/sendPhone")
    public void sendPhone(){
        String  phone = "18251515419";
        String code = "158852";
        //发送验证码，并且把验证码存到redis 设置一个过期时间为10分钟
        //redisTemplate.opsForValue().set(phone,code,600, TimeUnit.SECONDS);
        //举例因为是测试，所有设置验证码时间为20秒
        redisTemplate.opsForValue().set(phone,code,60, TimeUnit.SECONDS);

    }
    @RequestMapping("/checkCodePhone")
    public void checkCodePhone(){
        String  phone = "18251515419";
        String code = "123456";
        String redisCode = (String) redisTemplate.opsForValue().get(phone);
        if(redisCode!=null){
            if(code.equals(redisCode)){
                System.out.println("验证码验证通过");
            }else{
                System.out.println("验证码输入错误，请重新输入");
            }
        }else{
            System.out.println("验证码已失效，请重新获取");
        }
    }

    /**
     * 查询手机号
     * @param phone
     * @return
     */
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
