package com.xinguangnet.zookeeperclient2.client;

import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: duozl
 * @Date: 2018/3/28 16:00
 */
@FeignClient(name = "zookeeper-client", configuration = UploadClient.MultipartFileEncoder.class)
public interface UploadClient {

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart(name = "file") MultipartFile file);

    @Configuration
    class MultipartFileEncoder{

        @Bean
        public SpringFormEncoder springFormEncoder(){
            return new SpringFormEncoder();
        }

    }
}
