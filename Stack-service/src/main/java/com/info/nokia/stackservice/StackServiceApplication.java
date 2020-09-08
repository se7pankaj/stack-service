package com.info.nokia.stackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients("com.info.nokia.stackservice.service")
@EnableDiscoveryClient
@SpringBootApplication
public class StackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackServiceApplication.class, args);
	}

}
