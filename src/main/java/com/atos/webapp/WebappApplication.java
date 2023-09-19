package com.atos.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan
public class WebappApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		
	}

}
