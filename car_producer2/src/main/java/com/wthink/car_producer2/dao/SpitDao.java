package com.wthink.car_producer2.dao;

import com.wthink.car_producer2.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @描述：
 * @作者：王帅
 * @日期：2020-05-21 17:55
 **/
public interface SpitDao extends MongoRepository<Spit,String> {
    List findByParentid(String id);
}
