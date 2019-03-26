package com.xinguangnet.zookeeperclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: duozl
 * @Date: 2018/3/28 9:23
 */
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @RequestMapping(value = "/add")
    public int add(int arg1, int arg2) throws InterruptedException {
        Thread.sleep(5 * 1000L);
        return arg1 + arg2;
    }
}
