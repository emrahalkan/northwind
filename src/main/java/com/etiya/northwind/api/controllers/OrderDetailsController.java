package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
	private OrderDetailService orderDetailService;

	public OrderDetailsController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest) {
		return this.orderDetailService.add(createOrderDetailRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest) {
		return this.orderDetailService.delete(deleteOrderDetailRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<OrderDetailGetResponse> getById(@RequestParam int orderId, int productId) {
		return this.orderDetailService.getById(orderId, productId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<OrderDetailListResponse>> getAll(){
		return this.orderDetailService.getAll();
	}
	
}
