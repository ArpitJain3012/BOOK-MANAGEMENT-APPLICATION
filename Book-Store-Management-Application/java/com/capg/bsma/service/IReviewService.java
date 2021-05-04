package com.capg.bsma.service;
import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookModel;
import com.capg.bsma.model.CustomerModel;
import com.capg.bsma.model.ReviewModel;
import com.capg.bsma.entity.ReviewEntity;

public interface IReviewService {
	public List<ReviewModel> listAllReviews()throws BMSException;
	public ReviewModel addReview(ReviewModel review)throws BMSException;
	public boolean deleteReview(Long reviewid)throws BMSException;
	public ReviewModel updateReview(ReviewModel review)throws BMSException;
	public ReviewModel viewReview(Long reviewid)throws BMSException;
	public List<ReviewModel> listAllReviewsByBook(Long bid)throws BMSException;
	public List<ReviewModel> listAllReviewsByCustomer(Long cid)throws BMSException;
	
}



