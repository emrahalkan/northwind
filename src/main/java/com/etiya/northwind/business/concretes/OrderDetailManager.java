package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{
	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<OrderDetailListResponse>> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> responses = result.stream().map(orderDetails -> this.modelMapperService.forResponse()
				.map(orderDetails, OrderDetailListResponse.class)).collect(Collectors.toList());
	
		return new SuccessDataResult<List<OrderDetailListResponse>>(responses);	
	}

	@Override
	public Result add(CreateOrderDetailRequest createOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(createOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {	
		this.orderDetailRepository.deleteOrderDetailWithOrderIdAndProductId(deleteOrderDetailRequest.getOrderId(), deleteOrderDetailRequest.getProductId());
		return new SuccessResult("Added");
	}

	@Override
	public Result update(UpdateOrderDetailRequest updateOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(updateOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		return new SuccessResult("Updated");
	}

	@Override
	public DataResult<OrderDetailGetResponse> getById(int orderId, int productId) {
		OrderDetail orderDetail = this.orderDetailRepository.getOrderDetailWithOrderIdAndProductId(orderId,productId);
		OrderDetailGetResponse response = this.modelMapperService.forResponse().map(orderDetail, OrderDetailGetResponse.class);
		return new SuccessDataResult<>(response);	
	}
	
}
