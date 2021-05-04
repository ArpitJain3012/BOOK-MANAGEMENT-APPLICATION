package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CategoryModel;
import com.capg.bsma.model.CustomerModel;
import com.capg.bsma.model.OrderDetailsModel;

public interface IOrderDetailService {
	public OrderDetailsModel addOrderDetails(OrderDetailsModel odm) throws BMSException;
	public List<OrderDetailsModel> listOfOrderDetail() throws BMSException;
	public boolean deleteOrderDetail(Long id)throws BMSException;
	public OrderDetailsModel updateOrderDetail(OrderDetailsModel odm)throws BMSException;
	public OrderDetailsModel viewOrderDetails(Long odid) throws BMSException;

}
