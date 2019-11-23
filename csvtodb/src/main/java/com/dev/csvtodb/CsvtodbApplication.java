package com.dev.csvtodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
public class CsvtodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvtodbApplication.class, args);
	}

}
