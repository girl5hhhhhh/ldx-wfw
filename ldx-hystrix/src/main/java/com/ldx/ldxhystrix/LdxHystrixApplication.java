package com.ldx.ldxhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class LdxHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdxHystrixApplication.class, args);
    }

}
