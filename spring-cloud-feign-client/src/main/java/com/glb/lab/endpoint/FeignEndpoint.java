package com.glb.lab.endpoint;

import com.glb.lab.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignEndpoint {

    @Autowired
    TestClient testClient;

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    String getInfo(){
        return testClient.get();
    }
}
