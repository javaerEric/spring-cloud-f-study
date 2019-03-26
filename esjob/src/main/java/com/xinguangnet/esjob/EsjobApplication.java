package com.xinguangnet.esjob;

import com.xinguangnet.esjob.job.JobTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@EnableAutoConfiguration
@Configuration
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.xinguangnet.esjob"})
@SpringBootApplication
public class EsjobApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsjobApplication.class, args);
    }
}
