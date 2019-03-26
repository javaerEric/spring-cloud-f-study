package com.xinguangnet.configclient.controller;

import com.xinguangnet.configclient.config.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: duozl
 * @Date: 2018/3/30 9:54
 */
@RestController
public class ConfigController {

    @Autowired
    private Info info;

    @RequestMapping(value = "/info")
    public Info info(){
        return info;
    }
}
