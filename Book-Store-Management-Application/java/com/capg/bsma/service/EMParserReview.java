package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.ReviewEntity;
import com.capg.bsma.model.ReviewModel;
import com.capg.bsma.repo.IBookRepository;
import com.capg.bsma.repo.ICustomerRepository;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserReview {

	@Autowired
	private ICustomerRepository icr;

	@Autowired
	private IBookRepository ibr;

//default constructor
	public EMParserReview() {
		// no implementation
	}

//parameter constructor
	public EMParserReview(ICustomerRepository icr, IBookRepository ibr) {
		super();
		this.icr = icr;
		this.ibr = ibr;
	}

	/*
	 * linking entity with model
	 */
	public ReviewEntity parse(ReviewModel source) {
		return source == null ? null
				: new ReviewEntity(source.getReviewId(), source.getHeadline(), source.getComment(), source.getRating(),
						source.getReviewOn(), icr.findById(source.getCustId()).orElse(null),
						ibr.findById(source.getBookid()).orElse(null));
	}

	/*
	 * linking model with entity
	 */
	public ReviewModel parse(ReviewEntity source) {
		return source == null ? null
				: new ReviewModel(source.getReviewId(), source.getcust1().getCustomerId(),
						source.getbook1().getBookId(), source.getHeadline(), source.getComment(), source.getRating(),
						source.getReviewon());

	}

}
