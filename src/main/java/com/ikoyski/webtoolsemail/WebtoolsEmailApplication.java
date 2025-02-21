package com.ikoyski.webtoolsemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebtoolsEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtoolsEmailApplication.class, args);
	}

}
