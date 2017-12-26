package com.glb.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApp.class, args);
    }

    @RequestMapping("/test")
    String ribbonTest() {
        return "Hello World!";
    }

    @RequestMapping("/test/{name}")
    String ribbonTest(@PathVariable String name) {
        Logger.getAnonymousLogger().log(Level.INFO,"ribbonTest: {0}",name);
        return new StringBuilder().append("Hello ").append(name).append("!").toString();
    }

}
