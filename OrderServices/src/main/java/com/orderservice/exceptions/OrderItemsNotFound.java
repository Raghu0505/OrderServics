package com.orderservice.exceptions;

@SuppressWarnings("serial")
public class OrderItemsNotFound extends RuntimeException{
	
	public OrderItemsNotFound(String message) {
		super(message);
	}

}
