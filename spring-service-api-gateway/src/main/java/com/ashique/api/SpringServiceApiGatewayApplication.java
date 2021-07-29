package com.ashique.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
public class SpringServiceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceApiGatewayApplication.class, args);
	}

}
