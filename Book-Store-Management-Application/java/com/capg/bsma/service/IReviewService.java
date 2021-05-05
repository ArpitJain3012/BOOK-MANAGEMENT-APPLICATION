package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.ReviewModel;

public interface IReviewService {
	// list of reviews
	public List<ReviewModel> listAllReviews() throws BMSException;

	// add review in database
	public ReviewModel addReview(ReviewModel review) throws BMSException;

	// delete review in database
	public boolean deleteReview(Long reviewid) throws BMSException;

	// update review details in database
	public ReviewModel updateReview(ReviewModel review) throws BMSException;

	// view review by id
	public ReviewModel viewReview(Long reviewid) throws BMSException;

	// list of review by books
	public List<ReviewModel> listAllReviewsByBook(Long bid) throws BMSException;

	// list of review by customers
	public List<ReviewModel> listAllReviewsByCustomer(Long cid) throws BMSException;

}
