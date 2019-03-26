package com.xinguangnet.zookeeperclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.xinguangnet.zookeeperclient2.client"})
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperClient2Application.class, args);
	}
}
