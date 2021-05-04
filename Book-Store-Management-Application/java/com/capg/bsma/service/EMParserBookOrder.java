package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.model.BookOrderModel;
import com.capg.bsma.repo.ICustomerRepository;

@Service
public class EMParserBookOrder {

	@Autowired
	private ICustomerRepository icr;

	public BookOrderEntity parse(BookOrderModel source) {
		return source == null ? null
				: new BookOrderEntity(source.getOrderId(), source.getOrderDate(), source.getOrderTotal(),
						source.getStatus(), source.getPaymentMethod(), source.getRecipientphone(),
						source.getRecipientName(), icr.findById(source.getCustId()).orElse(null));
	}

	public BookOrderModel parse(BookOrderEntity source) {
		return source == null ? null
				: new BookOrderModel(source.getOrderId(), source.getCust().getCustomerId(), source.getOrderDate(),
						source.getOrderTotal(), source.getStatus(), source.getPaymentMethod(),
						source.getRecipientphone(), source.getRecipientName());
	}
}
