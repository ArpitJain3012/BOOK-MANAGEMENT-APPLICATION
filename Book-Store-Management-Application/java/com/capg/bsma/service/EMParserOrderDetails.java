package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.OrderDetailEntity;
import com.capg.bsma.model.OrderDetailsModel;
import com.capg.bsma.repo.IBookOrderRepository;
import com.capg.bsma.repo.IBookRepository;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserOrderDetails {
	@Autowired
	private IBookOrderRepository ibor;

	@Autowired
	private IBookRepository ibr;

	// default constructor
	public EMParserOrderDetails() {
		// no implementation
	}

	// parameter constructor
	public EMParserOrderDetails(IBookOrderRepository ibor, IBookRepository ibr) {
		super();
		this.ibor = ibor;
		this.ibr = ibr;
	}

	/*
	 * linking entity with model
	 */
	public OrderDetailEntity parse(OrderDetailsModel source) {
		return source == null ? null
				: new OrderDetailEntity(source.getOrder_detail_Id(), source.getQuantity(),
						ibor.findById(source.getBookorder_id()).orElse(null),
						ibr.findById(source.getBook_Id()).orElse(null));
	}

	/*
	 * linking model with entity
	 */
	public OrderDetailsModel parse(OrderDetailEntity source) {
		return source == null ? null
				: new OrderDetailsModel(source.getOrder_detail_Id(), source.getQuantity(), source.getBook().getBookId(),
						source.getBookorders().getOrderId());
	}

}
