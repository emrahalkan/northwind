package com.etiya.northwind.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
	@Query("Select od From OrderDetail od where order_id = :orderId and product_id = :productId")
	OrderDetail getOrderDetailWithOrderIdAndProductId(@Param("orderId") int orderId, @Param("productId") int productId);
	//OrderDetail getByOrder_OrderIdAndProduct_ProductId( int orderId,int productId);
	
	@Transactional
	@Modifying
	@Query("Delete From OrderDetail where order_id = :orderId and product_id = :productId")
	void deleteOrderDetailWithOrderIdAndProductId(@Param("orderId") int orderId, @Param("productId") int productId);
}
