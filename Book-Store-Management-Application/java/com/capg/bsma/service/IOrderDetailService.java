package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.OrderDetailsModel;

public interface IOrderDetailService {
	// add order details in database
	public OrderDetailsModel addOrderDetails(OrderDetailsModel odm) throws BMSException;

	// list of order details in database
	public List<OrderDetailsModel> listOfOrderDetail() throws BMSException;

	// delete order details in database
	public boolean deleteOrderDetail(Long id) throws BMSException;

	// update order details in database
	public OrderDetailsModel updateOrderDetail(OrderDetailsModel odm) throws BMSException;

	// view order details in database
	public OrderDetailsModel viewOrderDetails(Long odid) throws BMSException;

}
