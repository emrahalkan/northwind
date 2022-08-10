package com.etiya.northwind.business.requests.products;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
	private int productId;
	@NotBlank
	@NotNull
	@Size(min = 1, max = 10)
	private String productName;
	
	@Positive
	private double unitPrice;
	
	@PositiveOrZero
	private int unitsInStock;
	
	@Positive
	private int categoryId;
	private int supplierId;
}
