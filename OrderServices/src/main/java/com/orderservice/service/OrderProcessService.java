package com.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderservice.model.OrderItem;
import com.orderservice.model.Orders;


@Service
public interface OrderProcessService {

public void saveOrderdetails(Orders orders) ;

//public List<AllOrderItems> fechOrderDeatils(Integer id) ;

public List<Orders> findById(Long id);

public List<Orders> findAll();
public List<OrderItem> findAllOrderItems();
public void saveOrderItem(OrderItem orderItem);
	
	
}
