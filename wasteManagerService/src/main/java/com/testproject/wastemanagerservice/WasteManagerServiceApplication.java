package com.testproject.wastemanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.testproject.wastemanagerservice.model.entity"})
@EnableJpaRepositories(basePackages="com.testproject.wastemanagerservice.model.repository")
@EnableEurekaClient
public class WasteManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteManagerServiceApplication.class, args);
	}

}
