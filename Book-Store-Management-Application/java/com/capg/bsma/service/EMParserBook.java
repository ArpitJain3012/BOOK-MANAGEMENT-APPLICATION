package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.model.BookModel;
import com.capg.bsma.repo.ICategoryRepository;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserBook {

	@Autowired
	private ICategoryRepository icatrepo;

	// default constructor
	public EMParserBook() {
		// no implementation
	}

	// parameter constructor
	public EMParserBook(ICategoryRepository icatrepo) {
		super();
		this.icatrepo = icatrepo;
	}

	/*
	 * linking entity with model
	 */
	public BookEntity parse(BookModel source) {
		return source == null ? null
				: new BookEntity(source.getBookId(), source.getTitle(), source.getAuthor(), source.getDescription(),
						source.getIsbn(), source.getPrice(), source.getPubDate(), source.getLastUpDate(),
						icatrepo.findById(source.getCategoryId()).orElse(null));
	}

	/*
	 * linking model with entity
	 */
	public BookModel parse(BookEntity source) {
		return source == null ? null
				: new BookModel(source.getBookId(), source.getCategory().getCategoryId(), source.getTitle(),
						source.getAuthor(), source.getDescription(), source.getIsbn(), source.getPrice(),
						source.getPubDate(), source.getLastUpDate());

	}

}