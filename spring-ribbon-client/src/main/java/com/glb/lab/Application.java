package com.glb.lab;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class Application {

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    private Faker faker = new Faker();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/testRibbon")
    String ribbonTest() {
        String name = faker.name().fullName();
        return this.restTemplate.getForObject(
                new StringBuilder().append("http://spring-discovery-client/labs/discovery-client/test/").append(name).toString(), String.class);
    }

    @RequestMapping("/testFeing")
    String feingTest() {
        String name = faker.name().fullName();
        return discoveryClient.test(name);
    }

    @FeignClient("spring-discovery-client")
    interface DiscoveryClient {
        @RequestMapping(value = "/labs/discovery-client/test/{name}", method = RequestMethod.GET)
        String test(@PathVariable("name") String name);
    }



}
