package com.orderservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.orderservice")
public class OrderServices {

	public static void main(String[] args) {
		SpringApplication.run(OrderServices.class, args);
	}
 
}
