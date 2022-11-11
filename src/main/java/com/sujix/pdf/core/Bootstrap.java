package com.sujix.pdf.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sujix.pdf"})
public class Bootstrap {

	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

}
