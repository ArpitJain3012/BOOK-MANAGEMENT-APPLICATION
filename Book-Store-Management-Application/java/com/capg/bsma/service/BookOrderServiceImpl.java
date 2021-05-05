package com.capg.bsma.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookOrderModel;
import com.capg.bsma.repo.IBookOrderRepository;

/*
 * implementing service method for book order 
 */
@Service
public class BookOrderServiceImpl implements IBookOrderService {
	@Autowired
	private IBookOrderRepository ibr;

	@Autowired
	private EMParserBookOrder parser;

	// default constructor
	public BookOrderServiceImpl() {
		this.parser = new EMParserBookOrder();

	}

	// parameter constructor
	public BookOrderServiceImpl(IBookOrderRepository ibr) {
		super();
		this.ibr = ibr;
		this.parser = new EMParserBookOrder();
	}

	/*
	 * adding book order details
	 */

	@Transactional
	@Override
	public BookOrderModel createBook(BookOrderModel b) throws BMSException {
		if (b != null) {
			if ((b.getOrderId() == null)) {
				throw new BMSException("Order with this id already exists");
			} else {
				b = parser.parse(ibr.save(parser.parse(b)));
			}
		}
		return b;
	}

	/*
	 * retrieveing list of orders
	 */
	@Override
	public List<BookOrderModel> listAllBookOrder() throws BMSException {
		return ibr.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	/*
	 * deleting data by order id
	 */
	@Transactional
	@Override
	public boolean deleteBookOrder(Long bookid) throws BMSException {
		BookOrderEntity book = ibr.findById(bookid).orElse(null);
		if (book == null) {
			throw new BMSException("no order with id # " + bookid + " prsent");
		} else {
			ibr.deleteById(bookid);
			return true;
		}
	}

	/*
	 * updating or editing data of order module
	 */
	@Transactional
	@Override
	public BookOrderModel editBookOrder(BookOrderModel book) throws BMSException {
		if (book != null) {
			if (!ibr.existsById(book.getOrderId())) {
				throw new BMSException("No such order details");
			}
			book = parser.parse(ibr.save(parser.parse(book)));
		}
		return book;
	}
	/*
	 * viewing data of particular order
	 */

	@Override
	public BookOrderModel viewBookOrder(Long orderid) throws BMSException {
		BookOrderEntity book = (ibr.findById(orderid).orElse(null));
		if (book == null) {
			throw new BMSException("No book order for given id : ");
		} else {
			return parser.parse(ibr.findById(orderid).get());
		}
	}
}
