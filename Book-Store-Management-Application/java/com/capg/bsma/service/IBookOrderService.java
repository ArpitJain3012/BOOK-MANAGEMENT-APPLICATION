package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookOrderModel;

public interface IBookOrderService {
//add books order in database
	public BookOrderModel createBook(BookOrderModel b) throws BMSException;

	// list of books order from database
	public List<BookOrderModel> listAllBookOrder() throws BMSException;

	// delete books order in database by id
	public boolean deleteBookOrder(Long bookid) throws BMSException;

	// update books order in database
	public BookOrderModel editBookOrder(BookOrderModel book) throws BMSException;

	// view books order in database by id
	public BookOrderModel viewBookOrder(Long orderid) throws BMSException;
}
