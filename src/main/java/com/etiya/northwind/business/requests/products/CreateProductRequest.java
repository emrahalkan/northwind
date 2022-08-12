package com.etiya.northwind.business.requests.products;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

	@NotNull
	@Positive
	private int productId;
	
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 10)
	private String productName;
	

	@NotNull
	@Positive
	private double unitPrice;
	

	@NotNull
	@PositiveOrZero
	private int unitsInStock;
	

	@NotNull
	@Positive
	private int categoryId;
	

	@NotNull
	@Positive
	private int supplierId;
}
