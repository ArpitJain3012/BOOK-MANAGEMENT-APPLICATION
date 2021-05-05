package com.capg.bsma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.entity.ReviewEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.ReviewModel;
import com.capg.bsma.repo.IBookRepository;
import com.capg.bsma.repo.ICustomerRepository;
import com.capg.bsma.repo.IReviewRepository;

/*
 * implementing service method for customer
 */

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private IReviewRepository irr;

	@Autowired
	private ICustomerRepository icr;

	@Autowired
	private IBookRepository ibr;

	@Autowired
	private EMParserReview parser;

	// default constructor
	public ReviewServiceImpl() {
		this.parser = new EMParserReview();
	}

	// parameter constructor
	public ReviewServiceImpl(IReviewRepository irr, ICustomerRepository icr, IBookRepository ibr) {
		super();
		this.irr = irr;
		this.icr = icr;
		this.ibr = ibr;
		this.parser = new EMParserReview();
	}

	/*
	 * list of all reviews
	 */
	@Override
	public List<ReviewModel> listAllReviews() throws BMSException {
		return irr.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

	@Override
	@Transactional
	/*
	 * addReview is used to add reviews in the bsma
	 */
	public ReviewModel addReview(ReviewModel review) throws BMSException {

		if (review != null) {
			if (irr.existsById(review.getReviewId())) {
				throw new BMSException("Review with this id already exists");
			} else {
				review = parser.parse(irr.save(parser.parse(review)));
			}
		}
		return review;
	}

	@Transactional
	@Override
	/*
	 * deleteReview is used to delete reviews in the bsma
	 */
	public boolean deleteReview(Long reviewid) throws BMSException {
		ReviewEntity rev = irr.findById(reviewid).orElse(null);
		if (rev == null) {
			throw new BMSException("no review with id # " + reviewid + " present");
		} else {
			irr.deleteById(reviewid);
		}
		return true;
	}

	@Override
	@Transactional
	/*
	 * updateReview is used to update reviews by user
	 */
	public ReviewModel updateReview(ReviewModel review) throws BMSException {
		if (review != null) {
			if (!irr.existsById(review.getReviewId())) {
				throw new BMSException("No such review here");
			}
			review = parser.parse(irr.save(parser.parse(review)));
		}
		return review;
	}

	@Override
	/*
	 * viewReview is used to show reviews in the bsma
	 */
	public ReviewModel viewReview(Long reviewid) throws BMSException {
		ReviewEntity rev = irr.findById(reviewid).orElse(null);

		if (rev == null) {
			throw new BMSException("No customer found for givrn id : " + reviewid);
		}
		return parser.parse(irr.findById(reviewid).get());
	}

	@Override
	/*
	 * viewing Review by books
	 */
	public List<ReviewModel> listAllReviewsByBook(Long bid) throws BMSException {
		BookEntity revw = ibr.findById(bid).orElse(null);

		if (revw == null) {
			throw new BMSException("No Reviews by " + bid);
		}
		return revw.getRev().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	/*
	 * viewing Review by customers
	 */
	public List<ReviewModel> listAllReviewsByCustomer(Long cid) throws BMSException {
		CustomerEntity revw = icr.findById(cid).orElse(null);

		if (revw == null) {
			throw new BMSException("No Reviews by " + cid);
		}
		return revw.getRev().stream().map(parser::parse).collect(Collectors.toList());

	}

}
