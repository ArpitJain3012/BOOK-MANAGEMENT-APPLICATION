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
import com.capg.bsma.model.ReviewModel;
import com.capg.bsma.service.ReviewServiceImpl;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewAPI {

	@Autowired
	private ReviewServiceImpl rsimpl;

	/*
	 * listing all reviews
	 */
	@GetMapping
	public ResponseEntity<List<ReviewModel>> listAllReviewsAction() throws BMSException {
		return new ResponseEntity<>(rsimpl.listAllReviews(), HttpStatus.OK);
	}

	/*
	 * to add an review return : ReviewModel params : Review object
	 */
	@PostMapping
	public ResponseEntity<ReviewModel> addReviewAction(@RequestBody ReviewModel rev) throws BMSException {
		rev = rsimpl.addReview(rev);
		return new ResponseEntity<>(rev, HttpStatus.CREATED);
	}

	/*
	 * to delete an review return : void params : review Id
	 */
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<Boolean> deleteByUserIdAction(@PathVariable("reviewId") Long reviewId) throws BMSException {
		Boolean res = rsimpl.deleteReview(reviewId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response;
	}

	/*
	 * to update an review return : Review params : Review
	 */
	@PutMapping
	public ResponseEntity<ReviewModel> updateReviewAction(@RequestBody ReviewModel rev) throws BMSException {
		rev = rsimpl.updateReview(rev);
		return new ResponseEntity<>(rev, HttpStatus.OK);
	}

	/*
	 * to view an review return : Review params : Review
	 */
	@GetMapping("/{reviewId}")
	public ResponseEntity<ReviewModel> viewReviewAction(@PathVariable("reviewId") Long reviewId) throws BMSException {
		ResponseEntity<ReviewModel> response = null;
		ReviewModel rev = rsimpl.viewReview(reviewId);
		if (rev == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(rev, HttpStatus.OK);
		}
		return response;
	}

	/*
	 * list of reviews by book id
	 */
	@GetMapping("/{bookId}/BookModel")
	public ResponseEntity<List<ReviewModel>> listAllReviewsByBooksAction(@PathVariable("bookId") Long bookId)
			throws BMSException {
		return ResponseEntity.ok(rsimpl.listAllReviewsByBook(bookId));
	}

	/*
	 * list of reviews by customer id
	 */
	@GetMapping("/{custId}/CustomerModel")
	public ResponseEntity<List<ReviewModel>> listAllBooksByCategoryAction(@PathVariable("custId") Long cId)
			throws BMSException {
		return ResponseEntity.ok(rsimpl.listAllReviewsByCustomer(cId));
	}

}
