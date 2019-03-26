package com.xinguangnet.configclientzookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientZookeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientZookeeperApplication.class, args);
	}
}
