package com.orderservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.Orders;

@Repository
public interface FetechDetails extends CrudRepository<Orders, Long>{
	
	public List<Orders> findAll();
	
}
