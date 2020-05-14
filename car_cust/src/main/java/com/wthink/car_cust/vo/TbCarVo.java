package com.wthink.car_cust.vo;

import com.wthink.car_cust.pojo.TbCar;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/4/30 19:38
 */
@Data
public class TbCarVo extends TbCar {
    private String CarNewName;

    private BigDecimal ActualPrice;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date CarNewTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")//用于接收参数使用
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd") //用于接收参数使用
    private Date endTime;
}
