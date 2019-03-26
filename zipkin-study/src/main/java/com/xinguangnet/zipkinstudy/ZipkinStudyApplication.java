package com.xinguangnet.zipkinstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ZipkinStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinStudyApplication.class, args);
    }
}
