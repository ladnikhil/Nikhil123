package com.dev.SpringBatchDatabaseToCsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchDatabaseToCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDatabaseToCsvApplication.class, args);
	}
	

}
