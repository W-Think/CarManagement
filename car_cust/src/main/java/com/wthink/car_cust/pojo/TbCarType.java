package com.wthink.car_cust.pojo;

import java.io.Serializable;

public class TbCarType implements Serializable {
    private Integer id;

    private String carTypeName;

    private Integer carPid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName == null ? null : carTypeName.trim();
    }

    public Integer getCarPid() {
        return carPid;
    }

    public void setCarPid(Integer carPid) {
        this.carPid = carPid;
    }
}