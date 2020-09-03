package com.orderservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderservice.dao.FetchOrderItems;
import com.orderservice.dao.FetechDetails;
import com.orderservice.dao.OrderItemsSaveRepositiry;
import com.orderservice.dao.SaveOrderDetailsDao;
import com.orderservice.model.OrderItem;
import com.orderservice.model.Orders;
import com.orderservice.service.OrderProcessService;

@Component
public class OrderProcessServiceImpl  implements OrderProcessService{

	@Autowired
	private SaveOrderDetailsDao  saveOrderDetailsDao; 
	@Autowired
	private FetechDetails fetechDetails;
	@Autowired
	private FetchOrderItems fetchOrderItems;
	@Autowired
	private OrderItemsSaveRepositiry orderItemsSaveRepositiry;
	
		
	public void saveOrderdetails(Orders orders) {
		saveOrderDetailsDao.save(orders);
		}


	@Override
	public List<Orders> findById(Long id) {
		List<Orders> findByIdList =saveOrderDetailsDao.findById(id) ;
		return findByIdList;
	}


	@Override
	public List<Orders> findAll() {
		List<Orders>list=fetechDetails.findAll(); 
		return list;
	}


	@Override
	public void saveOrderItem(OrderItem orderItem) {
		orderItemsSaveRepositiry.save(orderItem);
		
	}


	@Override
	public List<OrderItem> findAllOrderItems() {
		List<OrderItem> listofOrderItems = fetchOrderItems.findAll();
		return listofOrderItems;
	}

	
		/*
		 * public List<AllOrderItems> fechOrderDeatils(Integer id) { List<AllOrderItems>
		 * OrderList= fetchOrderDetail.fechOrderDeatils(id); return OrderList; }
		 */


		/*
		 * public List<Orders> findById(Long id) { List<Orders> findByIdList =
		 * saveOrderDetailsDao.findById(id) ; return findByIdList; }
		 * 
		 * public List<Orders> findAllById(Long id) {
		 * List<Orders>list=fetechDetails.findAllById(id); return list; }
		 */


		

}
