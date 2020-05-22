package com.wthink.car_producer2.service;

import com.wthink.car_producer2.dao.SpitDao;
import com.wthink.car_producer2.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @描述：
 * @作者：王帅
 * @日期：2020-05-21 17:54
 **/
@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;

    public List<Spit> findAll() {
        return spitDao.findByParentid("2");
    }

    @Transactional
    public void add(Spit spit) {
        spitDao.save(spit);
    }

}
