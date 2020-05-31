package com.gandhi.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.gandhi.springweb")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebappApplication.class, args);
		
		System.out.println("spring boot application started");
	}

}
