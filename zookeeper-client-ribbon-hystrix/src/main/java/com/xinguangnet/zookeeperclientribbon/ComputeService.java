package com.xinguangnet.zookeeperclientribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: duozl
 * @Date: 2018/4/2 9:07
 */
@Service
public class ComputeService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String add(int arg1, int arg2){
        String url = "http://zookeeper-client/compute/add?arg1=" + arg1 + "&arg2=" + arg2;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(int arg1, int arg2){
        return "fallback";
    }
}
