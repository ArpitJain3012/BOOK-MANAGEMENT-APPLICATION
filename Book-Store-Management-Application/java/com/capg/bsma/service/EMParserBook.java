package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.model.BookModel;
import com.capg.bsma.repo.IBookRepository;
import com.capg.bsma.repo.ICategoryRepository;

@Service
public class EMParserBook {

	@Autowired
	private IBookRepository ibr;
	
	@Autowired
	private ICategoryRepository icr;

	public BookEntity parse(BookModel source) {
		return source == null ? null
				: new BookEntity(source.getBookId(), source.getTitle(), source.getAuthor(), source.getDescription(),
						source.getIsbn(), source.getPrice(), source.getPubDate(), source.getLastUpDate(),icr.findById(source.getCategoryId()).orElse(null));
	}

	public BookModel parse(BookEntity source) {
		return source == null ? null
				: new BookModel(source.getBookId(),source.getCategory().getCategoryId(), source.getTitle(), source.getAuthor(), source.getDescription(),
						source.getIsbn(), source.getPrice(), source.getPubDate(), source.getLastUpDate());

	}

}