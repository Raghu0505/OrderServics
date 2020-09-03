package com.orderservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.orderservice.model.OrderItem;

public interface FetchOrderItems extends CrudRepository<OrderItem, Long>{
	
	public List<OrderItem> findAll();
	

}
