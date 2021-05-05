package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.model.BookOrderModel;
import com.capg.bsma.repo.ICustomerRepository;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserBookOrder {

	@Autowired
	private ICustomerRepository icustrepo;

	// default constructor
	public EMParserBookOrder() {
	}

	// parameter constructor
	public EMParserBookOrder(ICustomerRepository icustrepo) {
		super();
		this.icustrepo = icustrepo;
	}

	/*
	 * linking entity with model
	 */
	public BookOrderEntity parse(BookOrderModel source) {
		return source == null ? null
				: new BookOrderEntity(source.getOrderId(), source.getOrderDate(), source.getOrderTotal(),
						source.getStatus(), source.getPaymentMethod(), source.getRecipientphone(),
						source.getRecipientName(), icustrepo.findById(source.getCustId()).orElse(null));
	}

	/*
	 * linking model with entity
	 */
	public BookOrderModel parse(BookOrderEntity source) {
		return source == null ? null
				: new BookOrderModel(source.getOrderId(), source.getCust().getCustomerId(), source.getOrderDate(),
						source.getOrderTotal(), source.getStatus(), source.getPaymentMethod(),
						source.getRecipientphone(), source.getRecipientName());
	}
}
