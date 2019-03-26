package com.xinguangnet.zookeeperclient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: duozl
 * @Date: 2018/3/28 15:53
 */
@RestController
public class UploadController {

    @PostMapping(value = "upload")
    public String uploadFile(@RequestPart(name = "file") MultipartFile file){
        return file.getName();
    }
}
