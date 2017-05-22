package com.glb.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //Runtime: Spring will seek interfaces and implement them.
public class FeignApp {

    public static void main(String[] args) {

        SpringApplication.run(FeignApp.class, args);
    }
}
