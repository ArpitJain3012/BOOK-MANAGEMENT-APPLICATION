package com.capg.bsma.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.OrderDetailEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.OrderDetailsModel;
import com.capg.bsma.repo.IOrderDetailRepository;
/*
 * implementing service method for customer
 */

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

	@Autowired
	private IOrderDetailRepository iodr;

	@Autowired
	private EMParserOrderDetails parser;

//default constructor
	public OrderDetailServiceImpl() {
		this.parser = new EMParserOrderDetails();
	}

//parameter constructor
	public OrderDetailServiceImpl(IOrderDetailRepository iodr) {
		super();
		this.iodr = iodr;
		this.parser = new EMParserOrderDetails();
	}

	/*
	 * adding order details
	 */
	@Transactional
	@Override
	public OrderDetailsModel addOrderDetails(OrderDetailsModel odm) throws BMSException {
		if (odm != null) {
			if (iodr.existsById(odm.getOrder_detail_Id())) {
				throw new BMSException("order details with this id already exists");
			} else {
				odm = parser.parse(iodr.save(parser.parse(odm)));
			}

		}
		return odm;
	}

	/*
	 * list of order details
	 */
	@Override
	public List<OrderDetailsModel> listOfOrderDetail() throws BMSException {
		return iodr.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

	/*
	 * deleting order details by particular id
	 */
	@Transactional
	@Override
	public boolean deleteOrderDetail(Long id) throws BMSException {
		OrderDetailEntity order = iodr.findById(id).orElse(null);
		if (order == null) {
			throw new BMSException("no order details with id # " + id + " present");
		} else {
			iodr.deleteById(id);
			return true;
		}

	}

	/*
	 * updating order details
	 */
	@Transactional
	@Override
	public OrderDetailsModel updateOrderDetail(OrderDetailsModel odm) throws BMSException {
		if (odm != null) {
			if (!iodr.existsById(odm.getOrder_detail_Id())) {
				throw new BMSException("No such order details");
			} else {
				odm = parser.parse(iodr.save(parser.parse(odm)));
			}
		}
		return odm;
	}

	@Override
	/*
	 * viewOrderDetails should return ordewr details of existing order
	 */
	public OrderDetailsModel viewOrderDetails(Long odid) throws BMSException {
		OrderDetailEntity od = iodr.findById(odid).orElse(null);
		if (od == null) {
			throw new BMSException("No book found for given id : " + odid);
		}
		return parser.parse(iodr.findById(odid).get());
	}

}
