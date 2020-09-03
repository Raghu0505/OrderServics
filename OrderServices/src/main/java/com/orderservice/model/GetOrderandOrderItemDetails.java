package com.orderservice.model;

import java.util.List;

import lombok.Data;

@Data
public class GetOrderandOrderItemDetails {

	private List<Orders>listofOrders;
	private List<OrderItem>listofOrderItems;
	
}
