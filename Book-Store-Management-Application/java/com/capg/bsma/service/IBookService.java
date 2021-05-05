package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookModel;

public interface IBookService {

	// add books in database
	public BookModel createBook(BookModel b) throws BMSException;

	// list of books from database
	public List<BookModel> listAllBooks() throws BMSException;

	// delete books in database by id
	public boolean deleteBook(Long bookid) throws BMSException;

	// update books in database
	public BookModel editBook(BookModel bookmod) throws BMSException;

	// view books in database by id
	public BookModel viewBook(Long bookid) throws BMSException;

	// view books in database by category
	public List<BookModel> listBooksByCategory(Long catid) throws BMSException;

}