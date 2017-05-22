package com.glb.lab.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${service.server.name}", path = "${service.server.path}",
        url = "${service.server.url}")
public interface TestClient {

    @RequestMapping (path = "/info", method = RequestMethod.GET)
    String get();
}
