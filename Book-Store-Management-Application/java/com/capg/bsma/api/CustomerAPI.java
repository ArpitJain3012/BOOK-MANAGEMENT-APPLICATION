package com.capg.bsma.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CustomerModel;
import com.capg.bsma.service.CustomerServiceImpl;

@RestController
@RequestMapping(path = "/customers")
public class CustomerAPI {

	@Autowired
	private CustomerServiceImpl csimpl;

	/*
	 * to retrieve all customers return : List<Customer> params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<CustomerModel>> findAllCustomerAction() throws BMSException {
		return new ResponseEntity<>(csimpl.listCustomers(), HttpStatus.OK);
	}

	/*
	 * to retrieve an customer return : Customer Model params : customer Id
	 */
	@GetMapping("/{custId}")
	public ResponseEntity<CustomerModel> findByCustomerIdAction(@PathVariable("custId") Long customerId)
			throws BMSException {
		return ResponseEntity.ok(csimpl.viewCustomer(customerId));
	}

	/*
	 * to add an customer return : CustomerModel params : customer object
	 */
	@PostMapping
	public ResponseEntity<CustomerModel> createCustomerAction(@RequestBody CustomerModel custmod) throws BMSException {
		custmod = csimpl.addCustomer(custmod);
		return new ResponseEntity<>(custmod, HttpStatus.CREATED);
	}

	/*
	 * to delete an customer return : void params : customer Id
	 */
	@DeleteMapping("/{custId}")
	public ResponseEntity<Boolean> deleteByCustomerIdAction(@PathVariable("custId") Long customerId)
			throws BMSException {
		Boolean res = csimpl.deleteCustomer(customerId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response;
	}

	/*
	 * to modify an customer return : Customer params : Customer
	 */
	@PutMapping
	public ResponseEntity<CustomerModel> updateCustomerAction(@RequestBody CustomerModel custmod) throws BMSException {
		custmod = csimpl.updateCustomer(custmod);
		return new ResponseEntity<>(custmod, HttpStatus.OK);
	}

}
