package com.xinguangnet.zookeeperclient2.service;

import com.xinguangnet.zookeeperclient2.client.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: duozl
 * @Date: 2018/3/28 9:28
 */
@Service
public class ComputeService {

    @Autowired
    private ComputeClient computeClient;

    public int add(int arg1, int arg2){
        return computeClient.add(arg1, arg2);
    }
}
