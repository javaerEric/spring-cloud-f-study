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

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add")
    public String add(int arg1, int arg2){
       return computeService.add(arg1, arg2);
    }

}
