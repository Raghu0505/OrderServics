package com.orderservice.dao;

import org.springframework.data.repository.Repository;

import com.orderservice.model.OrderItem;

public interface OrderItemsSaveRepositiry  extends Repository<OrderItem, Long> {

		public void save(OrderItem orderItem);

}
