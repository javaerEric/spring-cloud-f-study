package com.xinguangnet.zookeeperconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: duozl
 * @Date: 2018/3/28 15:22
 */
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/add")
    public int add(int arg1, int arg2){
        ServiceInstance serviceInstance = loadBalancerClient.choose("zookeeper-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
                + "/compute/add?arg1=" + arg1 + "&arg2=" + arg2;

        Integer result = restTemplate.getForObject(url, Integer.class);
        return result;
    }

}
