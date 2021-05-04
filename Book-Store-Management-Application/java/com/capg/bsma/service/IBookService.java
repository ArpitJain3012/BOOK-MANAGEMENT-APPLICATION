package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookModel;

public interface IBookService {

	public BookModel createBook(BookModel b) throws BMSException;

	public List<BookModel> listAllBooks() throws BMSException;

	public boolean deleteBook(Long bookid) throws BMSException;

	public BookModel editBook(BookModel bookmod) throws BMSException;

	public BookModel viewBook(Long bookid) throws BMSException;

	public List<BookModel> listBooksByCategory(Long catid) throws BMSException;

}