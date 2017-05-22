package com.glb.lab.service.impl;

import com.glb.lab.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getInfo() {
        return "Hello world!!! we are using Feign";
    }
}
