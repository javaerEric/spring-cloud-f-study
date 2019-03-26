package com.xinguangnet.zookeeperclient2.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: duozl
 * @Date: 2018/3/28 9:25
 */
@FeignClient(name = "zookeeper-client")
public interface ComputeClient {

    @RequestMapping(value = "/compute/add")
    public int add(@RequestParam(value = "arg1") int arg1, @RequestParam(value = "arg2") int arg2);
}
