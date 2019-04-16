package com.comp645.atm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.comp645.atm")
@SpringBootApplication
public class AtmApplication extends SpringBootServletInitializer{
	
	private static Logger logger = LogManager.getLogger(AtmApplication.class);
	
	public static void main(String[] args) {
		logger.info("Starting Spring Boot application..");
		ApplicationContext appcontext = SpringApplication.run(AtmApplication.class, args);
		System.out.println("main()...");
		for (String name: appcontext.getBeanDefinitionNames()) {
			System.out.println("Bean Name: " + name);
		}
	}
}
