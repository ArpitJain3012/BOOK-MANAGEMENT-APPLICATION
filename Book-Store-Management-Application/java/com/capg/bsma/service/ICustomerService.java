package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CustomerModel;

public interface ICustomerService {

	// adding customer details
	public CustomerModel addCustomer(CustomerModel c) throws BMSException;

	//list customer details
	public List<CustomerModel> listCustomers() throws BMSException;

	//delete customer details
	public boolean deleteCustomer(Long id) throws BMSException;

	//update customer details
	public CustomerModel updateCustomer(CustomerModel custmod) throws BMSException;

	//view customer details by id 
	public CustomerModel viewCustomer(Long custid) throws BMSException;
}
