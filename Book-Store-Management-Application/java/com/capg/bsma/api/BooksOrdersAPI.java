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
import com.capg.bsma.model.BookOrderModel;
import com.capg.bsma.service.BookOrderServiceImpl;

@RestController
@RequestMapping(path = "/bookorder")
public class BooksOrdersAPI {

	@Autowired
	private BookOrderServiceImpl bosimpl;

	/*
	 * to retrieve all book order return : List<BookOrder> params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<BookOrderModel>> findAllBookOrderAction() throws BMSException {
		return new ResponseEntity<>(bosimpl.listAllBookOrder(), HttpStatus.OK);
	}

	/*
	 * to retrieve an book order return : Book Order params : Order Id
	 */
	@GetMapping("/{orderId}")
	public ResponseEntity<BookOrderModel> findByBookOrderIdAction(@PathVariable("orderId") Long orderId)
			throws BMSException {
		return ResponseEntity.ok(bosimpl.viewBookOrder(orderId));
	}

	/*
	 * to add an book order return : BookOrder params : BookOrder object
	 */
	@PostMapping
	public ResponseEntity<BookOrderModel> createBookOrderAction(@RequestBody BookOrderModel bookordermod)
			throws BMSException {
		bookordermod = bosimpl.createBook(bookordermod);
		return new ResponseEntity<>(bookordermod, HttpStatus.CREATED);
	}

	/*
	 * to delete an book order return : void params : order Id
	 */
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Boolean> deleteByBookOrderIdAction(@PathVariable("orderId") Long orderId)
			throws BMSException {
		Boolean res = bosimpl.deleteBookOrder(orderId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response;
	}

	/*
	 * to modify an bookorder return : bookorder params : bookordermod
	 */
	@PutMapping
	public ResponseEntity<BookOrderModel> updateBookOrder(@RequestBody BookOrderModel bookordermod)
			throws BMSException {
		bookordermod = bosimpl.editBookOrder(bookordermod);
		return new ResponseEntity<>(bookordermod, HttpStatus.OK);
	}

}
