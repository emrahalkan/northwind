package com.etiya.northwind.business.requests.categories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {
	@NotBlank
	@NotNull
	private int categoryId;
	
	@NotBlank
	@NotNull
	private String categoryName;
}
