package com.glb.lab.endpoint;

import com.github.javafaker.Faker;
import com.glb.lab.client.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonEndpoint {

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

    @RequestMapping("/testRibbon")
    public String ribbonTest() {
        String name = faker.name().fullName();
        return this.restTemplate.getForObject(
                new StringBuilder().append("http://spring-discovery-client/labs/discovery-client/test/").append(name).toString(), String.class);
    }

    @RequestMapping("/testFeign")
    public String feingTest() {
        String name = faker.name().fullName();
        return discoveryClient.test(name);
    }
}
