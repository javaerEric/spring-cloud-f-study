package com.xinguangnet.zookeeperclient2.controller;

import com.xinguangnet.zookeeperclient2.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: duozl
 * @Date: 2018/3/28 9:29
 */
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add")
    public int add(int arg1, int arg2) {
        return computeService.add(arg1, arg2);
    }
}
