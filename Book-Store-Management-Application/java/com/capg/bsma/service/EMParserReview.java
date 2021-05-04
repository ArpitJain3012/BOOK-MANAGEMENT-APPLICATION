package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.ReviewEntity;
import com.capg.bsma.model.ReviewModel;
import com.capg.bsma.repo.IBookRepository;
import com.capg.bsma.repo.ICustomerRepository;
import com.capg.bsma.repo.IReviewRepository;

@Service
public class EMParserReview {

	@Autowired
	private ICustomerRepository icr;

	@Autowired
	private IBookRepository ibr;

	@Autowired
	private IReviewRepository irr;

	public ReviewEntity parse(ReviewModel source) {
		return source == null ? null
				: new ReviewEntity(source.getReviewId(), source.getHeadline(), source.getComment(), source.getRating(),
						source.getReviewOn(), icr.findById(source.getCustId()).orElse(null),
						ibr.findById(source.getBookid()).orElse(null));
	}

	public ReviewModel parse(ReviewEntity source) {
		return source == null ? null
				: new ReviewModel(source.getReviewId(), source.getcust1().getCustomerId(),
						source.getbook1().getBookId(), source.getHeadline(), source.getComment(), source.getRating(),
						source.getReviewon());

	}

}
