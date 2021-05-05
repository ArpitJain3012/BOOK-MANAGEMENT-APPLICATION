package com.capg.bsma.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ReviewModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "review id cannot be null")
	@NotBlank(message = "review id cannot be blank")
	private Long reviewId;

	@NotNull(message = "review id cannot be null")
	@NotBlank(message = "review id cannot be blank")
	private Long custId;

	@NotNull(message = "review id cannot be null")
	@NotBlank(message = "review id cannot be blank")
	private Long bookid;

	@NotNull(message = "headline cannot be null")
	private String headline;

	@NotNull(message = "comment cannot be null")
	private String comment;

	@NotNull(message = "rating cannot be null")
	private String rating;

	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "join date cannot be future date")
	private LocalDate reviewOn;

	// default constructor
	public ReviewModel() {
		// Intentionally left blank
	}

	// parametrized constructor
	public ReviewModel(
			@NotNull(message = "review id cannot be null") @NotBlank(message = "review id cannot be blank") Long reviewId,
			@NotNull(message = "review id cannot be null") @NotBlank(message = "review id cannot be blank") Long custId,
			@NotNull(message = "review id cannot be null") @NotBlank(message = "review id cannot be blank") Long bookid,
			@NotNull(message = "headline cannot be null") String headline,
			@NotNull(message = "comment cannot be null") String comment,
			@NotNull(message = "rating cannot be null") String rating,
			@PastOrPresent(message = "join date cannot be future date") LocalDate reviewOn) {
		super();
		this.reviewId = reviewId;
		this.custId = custId;
		this.bookid = bookid;
		this.headline = headline;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
	}
	/*
	 * generating getters and setters
	 */

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public LocalDate getReviewOn() {
		return reviewOn;
	}

	public void setReviewOn(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	/*
	 * generating hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((reviewId == null) ? 0 : reviewId.hashCode());
		result = prime * result + ((reviewOn == null) ? 0 : reviewOn.hashCode());
		return result;
	}

	/*
	 * generating equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewModel other = (ReviewModel) obj;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (headline == null) {
			if (other.headline != null)
				return false;
		} else if (!headline.equals(other.headline))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (reviewId == null) {
			if (other.reviewId != null)
				return false;
		} else if (!reviewId.equals(other.reviewId))
			return false;
		if (reviewOn == null) {
			if (other.reviewOn != null)
				return false;
		} else if (!reviewOn.equals(other.reviewOn))
			return false;
		return true;
	}

	/*
	 * generating to string
	 */
	@Override
	public String toString() {
		return String.format("ReviewModel [reviewId=%s, headline=%s, comment=%s, rating=%s, reviewOn=%s]", reviewId,
				headline, comment, rating, reviewOn);
	}

}
