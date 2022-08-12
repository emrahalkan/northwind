package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartInvoiceService;
import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cartInvoices")
public class CartInvoicesController {
	private CartInvoiceService cartInvoiceService;
	
	@Autowired
	public CartInvoicesController(CartInvoiceService cartInvoiceService) {
		this.cartInvoiceService = cartInvoiceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCartInvoiceRequest createCartInvoiceRequest) {
		return this.cartInvoiceService.add(createCartInvoiceRequest);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCartInvoiceRequest deleteCartInvoiceRequest) {
		return this.cartInvoiceService.delete(deleteCartInvoiceRequest);
	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateCartInvoiceRequest updateCartInvoiceRequest) {
		return this.cartInvoiceService.update(updateCartInvoiceRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<CartInvoiceReadResponse> getById(@RequestParam int id) {
		return this.cartInvoiceService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<CartInvoiceListResponse>> getAll() {
		return this.cartInvoiceService.getAll();
	}
}
