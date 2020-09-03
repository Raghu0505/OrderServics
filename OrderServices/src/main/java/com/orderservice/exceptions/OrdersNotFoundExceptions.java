package com.orderservice.exceptions;

import lombok.Data;



@SuppressWarnings("serial")
public class OrdersNotFoundExceptions extends RuntimeException{
	
	public OrdersNotFoundExceptions(String message) {
		super(message);
	}

	
	
	
	
}
