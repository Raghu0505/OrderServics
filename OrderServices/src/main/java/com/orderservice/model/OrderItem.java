package com.orderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Component
@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oid")
	public Long oid;
	@NotEmpty(message = "ProductCode is required for OrderItems")
	private String  productCode;
	@NotEmpty(message = "ProductName is required for OrderItems")
	private String productName;
	@NotEmpty(message = "Quantity is required for OrderItems")
	private String quantity;
	
	
}
