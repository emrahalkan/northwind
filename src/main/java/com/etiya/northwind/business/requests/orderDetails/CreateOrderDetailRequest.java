package com.etiya.northwind.business.requests.orderDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {
	
	@NotBlank
	@NotNull
	private int orderId;
	
	@NotBlank
	@NotNull
	private int productId;
	
	@NotBlank
	@NotNull
	@PositiveOrZero
	private double unitPrice;
	private int quantity;
	private double discount;
}
