package com.glb.lab.endpoint;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class TestEndpoint {

    @RequestMapping("/test")
    public String ribbonTest() {
        return "Hello World!";
    }

    @RequestMapping("/test/{name}")
    public String ribbonTest(@PathVariable String name) {
        Logger.getAnonymousLogger().log(Level.INFO,"ribbonTest: {0}",name);
        return new StringBuilder().append("Hello ").append(name).append("!").toString();
    }
}
