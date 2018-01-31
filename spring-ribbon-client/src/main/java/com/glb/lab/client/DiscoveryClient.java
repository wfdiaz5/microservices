package com.glb.lab.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-discovery-client")
public interface DiscoveryClient {

    @RequestMapping(value = "/labs/discovery-client/test/{name}", method = RequestMethod.GET)
    String test(@PathVariable("name") String name);

}
