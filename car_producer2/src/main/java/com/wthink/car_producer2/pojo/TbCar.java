package com.wthink.car_producer2.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbCar {
    private String id;

    private String carName;

    private Date createTime;

    private String carColor;

    private Integer carTypeId1;

    private Integer carTypeId2;

    private BigDecimal carPrice;

    private String rebate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    public Integer getCarTypeId1() {
        return carTypeId1;
    }

    public void setCarTypeId1(Integer carTypeId1) {
        this.carTypeId1 = carTypeId1;
    }

    public Integer getCarTypeId2() {
        return carTypeId2;
    }

    public void setCarTypeId2(Integer carTypeId2) {
        this.carTypeId2 = carTypeId2;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public String getRebate() {
        return rebate;
    }

    public void setRebate(String rebate) {
        this.rebate = rebate == null ? null : rebate.trim();
    }
}