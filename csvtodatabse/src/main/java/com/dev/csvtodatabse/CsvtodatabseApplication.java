package com.dev.csvtodatabse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"com.dev.csvtodatabse"})
@ComponentScan(basePackages={"com.dev.csvtodatabse"})
public class CsvtodatabseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvtodatabseApplication.class, args);
	}

}
