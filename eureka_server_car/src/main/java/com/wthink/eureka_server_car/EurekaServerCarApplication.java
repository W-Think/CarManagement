package com.wthink.eureka_server_car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCarApplication.class, args);
    }

}
