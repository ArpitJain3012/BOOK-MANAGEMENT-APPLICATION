package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CustomerModel;

public interface ICustomerService {

	public CustomerModel addCustomer(CustomerModel c)throws BMSException;
	public List<CustomerModel> listCustomers()throws BMSException;
	public boolean deleteCustomer(Long id)throws BMSException;
	public CustomerModel updateCustomer(CustomerModel custmod)throws BMSException;
	public CustomerModel viewCustomer(Long custid)throws BMSException;
}
