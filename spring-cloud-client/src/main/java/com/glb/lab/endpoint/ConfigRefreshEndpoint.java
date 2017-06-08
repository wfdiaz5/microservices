package com.glb.lab.endpoint;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "refresh")
@RefreshScope
public class ConfigRefreshEndpoint {

    private String word;

    @RequestMapping("/message/refresh")
    public String showLuckyWord() {
        return "The message is -->" + word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
