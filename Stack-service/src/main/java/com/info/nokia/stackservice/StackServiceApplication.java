package com.info.nokia.stackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.in28minutes.microservices.currencyconversionservice")
@EnableDiscoveryClient
public class StackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackServiceApplication.class, args);
	}

}
