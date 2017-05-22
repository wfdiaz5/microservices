package com.glb.lab.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by william.diaz on 5/9/2017.
 */
@RestController
public class LuckyEndpoint {

    @Value("${word}") String lucky;

    @RequestMapping("/message")
    public String showLuckyWord() {
        return "The message is -->" + lucky;
    }
}
