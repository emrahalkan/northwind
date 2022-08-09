package com.etiya.northwind.business.responses.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailGetResponse {
	private int orderId;
	private int productId;
	private double unitPrice;
	private int quantity;
	private double discount;
}
