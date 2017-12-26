package com.glb.lab.endpoint;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigEndpoint {

    @Value("${refresh.word}")
    String word;

    @RequestMapping("/message")
    public String showLuckyWord() {
        return "The message is -->" + word;
    }
}
