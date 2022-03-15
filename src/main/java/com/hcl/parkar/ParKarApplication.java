package com.hcl.parkar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hcl.parkar")
public class ParKarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParKarApplication.class, args);
	}

}
