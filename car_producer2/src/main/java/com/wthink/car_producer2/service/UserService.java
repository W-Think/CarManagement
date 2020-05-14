package com.wthink.car_producer2.service;

import cn.hutool.crypto.SecureUtil;
import com.wthink.car_producer2.dao.TbCarUserMapper;
import com.wthink.car_producer2.pojo.TbCarUser;
import com.wthink.car_producer2.pojo.TbCarUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/13 20:22
 */
@Service
public class UserService {
    @Autowired
    private TbCarUserMapper tcum;

    @Transactional
    public int registerToUser(TbCarUser tbCarUser) {
        return tcum.insert(tbCarUser);
    }

    public String checkPhone(String phone) {
        //根据手机号去查询是否有当前用户，如果有，则返回消息为手机号已存在，请重新输入
        //如果没有，则提示用户手机号可用
        TbCarUserExample tbUserExample = new TbCarUserExample();
        //select * from t_user where phone = #{phone}
        tbUserExample.createCriteria().andPhoneEqualTo(phone);
        List<TbCarUser> tbCarUsers = tcum.selectByExample(tbUserExample);
        //如果返回的集合中的数据大于0 ，则当前数据肯定已经存在了
        if(null!=tbCarUsers && tbCarUsers.size()>0){
            //已存在
            return "0";
        }else{
            return "1";
        }
    }

    public TbCarUser checkPwdAndUserName(String loginName, String pwd) {
        TbCarUserExample tbCarUserExample = new TbCarUserExample();
        //select * from t_user where phone = #{phone}
        //对密码进行加密的对比
        String md5Pwd = SecureUtil.md5(pwd);//密码md5 加密


        tbCarUserExample.createCriteria().andLoginNameEqualTo(loginName).andPwdEqualTo(md5Pwd);
        List<TbCarUser> tbCarUsers = tcum.selectByExample(tbCarUserExample);
        if(null!=tbCarUsers && tbCarUsers.size()>0){
            return  tbCarUsers.get(0);
        }
        return null;
    }
}
