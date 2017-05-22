package com.glb.lab.endpoint;

import com.glb.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @RequestMapping (value = "/info")
    public String getInfo(){
        return userService.getInfo();
    }
}
