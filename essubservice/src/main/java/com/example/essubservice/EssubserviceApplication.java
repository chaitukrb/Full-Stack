package com.example.essubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EssubserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EssubserviceApplication.class, args);
	}

}
