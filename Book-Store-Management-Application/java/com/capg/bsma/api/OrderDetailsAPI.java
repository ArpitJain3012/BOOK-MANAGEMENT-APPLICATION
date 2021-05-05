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
import com.capg.bsma.model.OrderDetailsModel;
import com.capg.bsma.service.OrderDetailServiceImpl;

@RestController
@RequestMapping(path = "/orders")
public class OrderDetailsAPI {
	@Autowired
	private OrderDetailServiceImpl odService;
	/*
	 * list of all order details
	 */

	@GetMapping
	public ResponseEntity<List<OrderDetailsModel>> viewAllOrderDetailsAction() throws BMSException {
		return new ResponseEntity<>(odService.listOfOrderDetail(), HttpStatus.OK);
	}

	/*
	 * adding order details
	 */
	@PostMapping
	public ResponseEntity<OrderDetailsModel> addOrderDetailsAction(@RequestBody OrderDetailsModel od)
			throws BMSException {
		od = odService.addOrderDetails(od);
		return new ResponseEntity<>(od, HttpStatus.CREATED);
	}

	/*
	 * updating order details
	 */
	@PutMapping
	public ResponseEntity<OrderDetailsModel> editOrderDetailsAction(@RequestBody OrderDetailsModel od)
			throws BMSException {
		od = odService.updateOrderDetail(od);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

	/*
	 * deleting order details
	 */
	@DeleteMapping("/{odId}")
	public ResponseEntity<Boolean> removeOrderDetailsAction(@PathVariable("odId") Long odId) throws BMSException {
		Boolean res = odService.deleteOrderDetail(odId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response;
	}
	/*
	 * find by order detail id
	 */

	@GetMapping("/{odId}")
	public ResponseEntity<OrderDetailsModel> findByOrderDetailsIdAction(@PathVariable("odId") Long oId)
			throws BMSException {
		return ResponseEntity.ok(odService.viewOrderDetails(oId));
	}
}
