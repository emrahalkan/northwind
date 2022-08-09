package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;

@Service
public class OrderManager implements OrderService{
	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;
	
	public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
		this.orderRepository = orderRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<OrderListResponse> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> responses = result.stream().map(order-> this.modelMapperService.forResponse()
				.map(order, OrderListResponse.class)).collect(Collectors.toList());
		
		for (int i = 0; i< responses.size();i++ ) {
			responses.get(i).setFullName(
					result.get(i).getEmployee().getFirstName()+ " " + result.get(i).getEmployee().getLastName());
		}
		return responses;	
	}
	
}
