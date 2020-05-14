package com.wthink.car_producer2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wthink.car_producer2.dao")
@EnableFeignClients
public class CarProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(CarProducer2Application.class, args);
    }

}
