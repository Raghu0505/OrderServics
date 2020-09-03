package com.orderservice.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.orderservice.model.Orders;

@org.springframework.stereotype.Repository
public interface  SaveOrderDetailsDao extends Repository<Orders, Long> {

public void save(Orders orders);

public List<Orders> findById(Long id);







}
