package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookOrderModel;

public interface IBookOrderService {

	public BookOrderModel createBook(BookOrderModel b)throws BMSException;
	public List<BookOrderModel> listAllBookOrder()throws BMSException;
	public boolean deleteBookOrder(Long bookid)throws BMSException;
	public BookOrderModel editBookOrder(BookOrderModel book)throws BMSException;
	public BookOrderModel viewBookOrder(Long orderid)throws BMSException;
}
