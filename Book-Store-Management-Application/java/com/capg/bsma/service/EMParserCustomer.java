package com.capg.bsma.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.model.CustomerModel;
import com.capg.bsma.repo.ICustomerRepository;

@Service
public class EMParserCustomer {

	@Autowired
	private ICustomerRepository icr;

	public CustomerEntity parse(CustomerModel source) {
		return source == null ? null
				: new CustomerEntity(source.getCustomerId(), source.getFullName(), source.getEmail(),
						source.getPassword(), source.getMobileNumber(), source.getRegisterOn(), source.getAm());
	}

	public CustomerModel parse(CustomerEntity source) {
		return source == null ? null
				: new CustomerModel(source.getCustomerId(), source.getFullName(), source.getEmail(),
						source.getPassword(), source.getMobileNumber(), source.getRegisterOn(), source.getAm());
	}

}
