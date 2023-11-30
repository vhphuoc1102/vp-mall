package com.phuocvh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VpUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(VpUserApplication.class, args);
    }
}
