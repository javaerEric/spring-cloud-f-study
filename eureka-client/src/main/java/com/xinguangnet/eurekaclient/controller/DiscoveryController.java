package com.xinguangnet.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: duozl
 * @Date: 2018/3/27 16:57
 */
@RestController
@RequestMapping(value = "/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/services")
    public List<String> discoveryServices() {
        List<String> services = client.getServices();
        return services;
    }
}
