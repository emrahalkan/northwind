package com.etiya.northwind.business.requests.customers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
	
	@NotBlank
	@NotNull
	private String customerId;
	
	@NotBlank
	@NotNull
	private String companyName;
	
	@NotBlank
	@NotNull
	private String contactName;
	
	@NotBlank
	@NotNull
	private String contactTitle;
	
	private String address;
	private String city;
}
