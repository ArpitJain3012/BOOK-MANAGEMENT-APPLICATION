package com.capg.bsma.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CustomerModel;
import com.capg.bsma.repo.ICustomerRepository;

/*
 * implementing service method for customer
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository icr;

	@Autowired
	private EMParserCustomer parser;

	// default constructor
	public CustomerServiceImpl() {
		this.parser = new EMParserCustomer();
	}

	// parameter constructor
	public CustomerServiceImpl(ICustomerRepository icr) {
		super();
		this.icr = icr;
		this.parser = new EMParserCustomer();
	}

	/*
	 * adding data in customer database
	 */
	@Transactional
	@Override
	public CustomerModel addCustomer(CustomerModel c) throws BMSException {
		if (c != null) {
			if (icr.existsById(c.getCustomerId())) {
				throw new BMSException("Customer with this id already exists");
			} else {
				c = parser.parse(icr.save(parser.parse(c)));
			}
		}
		return c;
	}

	/*
	 * retrieving list of customer from database
	 */
	@Override
	public List<CustomerModel> listCustomers() throws BMSException {
		return icr.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	/*
	 * deleting customer details in database
	 */
	@Transactional
	@Override
	public boolean deleteCustomer(Long id) throws BMSException {
		CustomerEntity cust = icr.findById(id).orElse(null);
		if (cust == null) {
			throw new BMSException("no customer with id # " + id + " prsent");
		} else {
			icr.deleteById(id);
			return true;
		}

	}

	/*
	 * updating customer details in database
	 */
	@Transactional
	@Override
	public CustomerModel updateCustomer(CustomerModel custmod) throws BMSException {

		if (custmod != null) {
			if (!icr.existsById(custmod.getCustomerId())) {
				throw new BMSException("No such customer");
			} else {
				custmod = parser.parse(icr.save(parser.parse(custmod)));
			}
		}
		return custmod;
	}

	/*
	 * retrieving customer details with particular customer id
	 */
	@Override
	public CustomerModel viewCustomer(Long custid) throws BMSException {
		CustomerEntity cust = icr.findById(custid).orElse(null);
		if (cust == null) {
			throw new BMSException("No customer found for givrn id : " + custid);
		} else {
			return parser.parse(icr.findById(custid).get());
		}
	}

}
