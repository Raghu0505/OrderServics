package com.orderservice.daoImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.orderservice.dao.SaveOrderDetailsDao;
import com.orderservice.model.Orders;

@Component
public class SaveOrderDaoImp implements SaveOrderDetailsDao{


	@Override
	public void save(Orders orders) {
		save(orders);
		
	}



	@Override
	public List<Orders> findById(Long id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

	



	
}
