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
import com.capg.bsma.model.BookModel;
import com.capg.bsma.service.BookServiceImpl;

@RestController
@RequestMapping(path = "/books")
public class BooksAPI {
	@Autowired
	private BookServiceImpl bookService;

	/*
	 * list of all books
	 */
	@GetMapping
	public ResponseEntity<List<BookModel>> listAllBooksAction() throws BMSException {
		return new ResponseEntity<>(bookService.listAllBooks(), HttpStatus.OK);
	}

	/*
	 * adding books data
	 */
	@PostMapping
	public ResponseEntity<BookModel> createBookAction(@RequestBody BookModel book) throws BMSException {
		book = bookService.createBook(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}

	/*
	 * updating data of books
	 */
	@PutMapping
	public ResponseEntity<BookModel> editBookAction(@RequestBody BookModel book) throws BMSException {
		book = bookService.editBook(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	/*
	 * book data by book id
	 */
	@GetMapping("/{bookId}")
	public ResponseEntity<BookModel> findByBookIdAction(@PathVariable("bookId") Long bId) throws BMSException {
		return ResponseEntity.ok(bookService.viewBook(bId));
	}
	/*
	 * deleting books by book id
	 */

	@DeleteMapping("/{bookId}")
	public ResponseEntity<Boolean> deleteBookAction(@PathVariable("bookId") Long bookId) throws BMSException {
		Boolean res = bookService.deleteBook(bookId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response;
	}
	/*
	 * list of books by category
	 */

	@GetMapping("/{catId}/CategoryModel")
	public ResponseEntity<List<BookModel>> listAllBooksByCategoryAction(@PathVariable("catId") Long catId)
			throws BMSException {
		return ResponseEntity.ok(bookService.listBooksByCategory(catId));
	}
}
