package com.info.nokia.services.stackdbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StackDbserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackDbserviceApplication.class, args);
	}

}
