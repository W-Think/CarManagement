package com.wthink.car_producer2.controller;

import com.wthink.car_producer2.pojo.Spit;
import com.wthink.car_producer2.service.SpitService;
import com.wthink.car_producer2.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @描述：
 * @作者：王帅
 * @日期：2020-05-21 17:54
 **/
@Controller
@RequestMapping("/spit")
public class SpitC {
    @Autowired
    private SpitService spitService;
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping("/queryList")
    public String findAll(Model model){
        List<Spit> spitList = spitService.findAll();
        model.addAttribute("spitList",spitList);
        return "car_comment";
    }

    @RequestMapping("/thumbup")
    public String thumbup(String _id){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(_id));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"comment");
        return "redirect:/spit/queryList";
    }
    @RequestMapping("/add")
    public String add(Spit spit){
        IdWorker idWorker = new IdWorker();
        spit.setPublishtime(new Date());
        spit.setThumbup(0);
        spit.setComment(0);
        spit.setParentid("2");
        spit.set_id(idWorker.nextId()+"");
        if(!StringUtils.isEmpty(spit.getParentid())){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"comment");
        }
        spitService.add(spit);
        return "redirect:/comm/list";
    }
}
