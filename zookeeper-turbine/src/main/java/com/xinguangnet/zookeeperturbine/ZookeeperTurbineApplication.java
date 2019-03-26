package com.xinguangnet.zookeeperturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableDiscoveryClient
@EnableTurbine
@SpringBootApplication
public class ZookeeperTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperTurbineApplication.class, args);
	}
}
