package com.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.food.utility.OrderConformation;

@SpringBootApplication
public class FoodTruckApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con=SpringApplication.run(FoodTruckApplication.class, args);
		OrderConformation o=(OrderConformation) con.getBean(OrderConformation.class);
	}

}
