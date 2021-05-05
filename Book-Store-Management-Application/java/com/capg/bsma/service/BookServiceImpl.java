package com.capg.bsma.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookModel;
import com.capg.bsma.repo.IBookRepository;
import com.capg.bsma.repo.ICategoryRepository;

/*
 * implementing service methods for book
 */
@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookrepo;

	@Autowired
	private EMParserBook parser;

	@Autowired
	private ICategoryRepository catrepo;

	// default constructor
	public BookServiceImpl() {
		this.parser = new EMParserBook();
	}

	// parameter constructor
	public BookServiceImpl(IBookRepository bookrepo, ICategoryRepository catrepo) {
		super();
		this.bookrepo = bookrepo;
		this.parser = new EMParserBook();
		this.catrepo = catrepo;
	}

	@Transactional
	@Override
	/*
	 * createBook should create books in database
	 */
	public BookModel createBook(BookModel b) throws BMSException {
		if (b != null) {
			if (bookrepo.existsById(b.getBookId())) {
				throw new BMSException("book with this id already exists " + b.getBookId());
			}
			b = parser.parse(bookrepo.save(parser.parse(b)));
		}

		return b;
	}

	@Override
	/*
	 * listAllBooks should return list of existing books as BookModel List
	 */
	public List<BookModel> listAllBooks() throws BMSException {

		return bookrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Transactional
	@Override
	/*
	 * deleteBook should return list of existing books
	 */
	public boolean deleteBook(Long bookid) throws BMSException {
		BookEntity cust = bookrepo.findById(bookid).orElse(null);
		if (cust == null) {
			throw new BMSException("no books with id # " + bookid + " prsent");
		} else {
			bookrepo.deleteById(bookid);
			return true;
		}

	}

	@Transactional
	@Override
	/*
	 * editBook should edit books details in database
	 */
	public BookModel editBook(BookModel bookmod) throws BMSException {

		if (bookmod != null) {
			if (!bookrepo.existsById(bookmod.getBookId())) {
				throw new BMSException("No books in the list");
			}

			bookmod = parser.parse(bookrepo.save(parser.parse(bookmod)));
		}

		return bookmod;
	}

	@Override
	/*
	 * viewBook should return list of existing books
	 */
	public BookModel viewBook(Long bookid) throws BMSException {
		BookEntity book = bookrepo.findById(bookid).orElse(null);
		if (book == null) {
			throw new BMSException("No book found for given id : " + bookid);
		}
		return parser.parse(bookrepo.findById(bookid).get());
	}

	@Override
	/*
	 * viewBook should return list of existing books as categorymodel
	 */
	public List<BookModel> listBooksByCategory(Long catid) throws BMSException {

		CategoryEntity catentity = catrepo.findById(catid).orElse(null);

		if (catentity == null) {
			throw new BMSException("No Books by " + catid);
		}
		return catentity.getBook().stream().map(parser::parse).collect(Collectors.toList());
	}

}