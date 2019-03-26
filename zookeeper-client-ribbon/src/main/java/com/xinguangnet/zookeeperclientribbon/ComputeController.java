package com.xinguangnet.zookeeperclientribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: duozl
 * @Date: 2018/3/28 15:39
 */
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public int add(int arg1, int arg2){
        String url = "http://zookeeper-client/compute/add?arg1=" + arg1 + "&arg2=" + arg2;
        int result = restTemplate.getForObject(url, Integer.class);
        return result;
    }

}
