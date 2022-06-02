package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ProductVariantDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductVariantDemoApplication.class, args);
	}

}
