package com.orderservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderservice.exceptions.OrderItemsNotFound;
import com.orderservice.exceptions.OrdersNotFoundExceptions;
import com.orderservice.model.GetOrderandOrderItemDetails;
import com.orderservice.model.ListOrders;
import com.orderservice.model.ListofOrderItems;
import com.orderservice.model.OrderItem;
import com.orderservice.model.Orders;
import com.orderservice.service.OrderProcessService;

@SuppressWarnings("unused")
@RestController
@Validated
public class OrderController {

	@Autowired
	private OrderProcessService orderProcessService;

	@PostMapping(path = "/saveOrder", consumes = { "application/json" })
	public void saveOrderdetails(@RequestBody @Valid List<Orders> listOrders) {
		if(listOrders!=null && !listOrders.isEmpty()) {
		for (Orders orders : listOrders) {
			orderProcessService.saveOrderdetails(orders);
		}}else {
			throw new OrdersNotFoundExceptions("NoOrderFoundException");
		}
	}

	@PostMapping(path = "/saveOrderItem", consumes = { "application/json" })
	public void saveOrderItemdetails(@RequestBody @Validated List<OrderItem> listofOrderItem) {

		if(listofOrderItem!=null && !listofOrderItem.isEmpty()) {
		for (OrderItem orderItems : listofOrderItem) {
			orderProcessService.saveOrderItem(orderItems);
		}}

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<com.orderitem.serviceImpl.OrderItems> responseEntity = restTemplate
				.getForEntity("http://localhost:1001/getOrderItems", com.orderitem.serviceImpl.OrderItems.class);
		if(responseEntity!=null) {
		com.orderitem.serviceImpl.OrderItems orderItems = responseEntity.getBody();
		List<com.orderitem.model.OrderItem> orderItemsServiceData = orderItems.getListOfOrderItems();
		ListofOrderItems listserviceItems = new ListofOrderItems();
		// orderItemsServiceData.forEach(x -> System.out.println("orderitem services
		// values=" + x));
		for (com.orderitem.model.OrderItem orderItem : orderItemsServiceData) {
			OrderItem serivceItems = new OrderItem();
			serivceItems.setProductCode(orderItem.getProductCode());
			serivceItems.setProductName(orderItem.getProductName());
			serivceItems.setQuantity(orderItem.getQuantity());
			List<OrderItem> list = new ArrayList<OrderItem>();
			list.add(serivceItems);
			listserviceItems.setListofOrderItems(list);
			orderProcessService.saveOrderItem(serivceItems);

		}}else throw new OrderItemsNotFound("OrderItemsNotFound");

	}

	@GetMapping(path = "/getDetails", consumes = { "application/json" })
	public GetOrderandOrderItemDetails getOrderAndOrderItemdetails() {

		GetOrderandOrderItemDetails allDetails = new GetOrderandOrderItemDetails();
			List<Orders> listofOrder = orderProcessService.findAll();
			List<OrderItem> findAllOrderItems = orderProcessService.findAllOrderItems();
			allDetails.setListofOrderItems(findAllOrderItems);
			allDetails.setListofOrders(listofOrder);
			return 	allDetails;
			}


	@GetMapping(path = "/listOrderItem", consumes = { "application/json" })
	public ListofOrderItems getOrderItemdetails() {
		ListofOrderItems orderItems = new ListofOrderItems();

		List<OrderItem> findAllOrderItems = orderProcessService.findAllOrderItems();

		orderItems.setListofOrderItems(findAllOrderItems);
		return orderItems;

	}

	@GetMapping(path = "/listOrders", consumes = { "application/json" })
	public ResponseEntity<ListOrders> getOrderDetails(@RequestBody List<Orders> orders) {
		ListOrders listofOrders = new ListOrders();

		List<Orders> listofOrder = orderProcessService.findAll();
		listofOrders.setListofOrders(listofOrder);

		return new ResponseEntity<ListOrders>(listofOrders, HttpStatus.OK);
	}

}
