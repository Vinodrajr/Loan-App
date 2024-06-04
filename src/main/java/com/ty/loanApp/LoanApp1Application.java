package com.ty.loanApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(LoanApp1Application.class, args);
	}

}
