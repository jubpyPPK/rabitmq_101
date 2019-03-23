package com.ppk.rabbitmq_101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Rabbitmq101Application {

	public static void main(String[] args) {
		SpringApplication.run(Rabbitmq101Application.class, args);
	}

}
