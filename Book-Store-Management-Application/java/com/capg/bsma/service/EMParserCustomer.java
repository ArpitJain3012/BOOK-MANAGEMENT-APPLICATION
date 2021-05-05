package com.capg.bsma.service;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.model.CustomerModel;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserCustomer {

	/*
	 * linking entity with model
	 */
	public CustomerEntity parse(CustomerModel source) {
		return source == null ? null
				: new CustomerEntity(source.getCustomerId(), source.getEmail(), source.getFullName(),
						source.getPassword(), source.getMobileNumber(), source.getRegisterOn(), source.getAm());
	}

	/*
	 * linking model with entity
	 */
	public CustomerModel parse(CustomerEntity source) {
		return source == null ? null
				: new CustomerModel(source.getCustomerId(), source.getEmail(), source.getFullName(),
						source.getPassword(), source.getMobileNumber(), source.getRegisterOn(), source.getAm());
	}

}
