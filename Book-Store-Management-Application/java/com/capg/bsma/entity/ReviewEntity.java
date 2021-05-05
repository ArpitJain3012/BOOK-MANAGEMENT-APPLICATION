package com.capg.bsma.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * linking review database with ReviewEntity
 */
@Entity
@Table(name = "review")

public class ReviewEntity {
	// primary key
	@Id
	@Column(name = "review_Id")
	private Long reviewId;

	// headline of review
	@Column(name = "headline", length = 30)
	private String headline;

	// comments given by customer
	@Column(name = "comments", length = 20)
	private String comment;

	// rating given by customer
	@Column(name = "rating", length = 20)
	private String rating;

	// review given on date
	@Column(name = "review_On")
	private LocalDate reviewOn;

	/*
	 * using many to one association for mapping with customer entity
	 */

	@ManyToOne
	@JoinColumn(name = "customer_Id")
	private CustomerEntity cust1;

	/*
	 * using many to one association for mapping with book entity
	 */

	@ManyToOne
	@JoinColumn(name = "book_Id")
	private BookEntity book1;

	// default constructor
	public ReviewEntity() {
		// no implementation
	}

	// parameter constructor
	public ReviewEntity(Long reviewId, String headline, String comment, String rating, LocalDate reviewOn,
			CustomerEntity cust1, BookEntity book1) {
		super();
		this.reviewId = reviewId;
		this.headline = headline;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
		this.cust1 = cust1;
		this.book1 = book1;
	}

	/*
	 * getters and setters generating
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

	public LocalDate getReviewon() {
		return reviewOn;
	}

	public void setReviewon(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}

	public CustomerEntity getcust1() {
		return cust1;
	}

	public void setcust1(CustomerEntity cust1) {
		this.cust1 = cust1;
	}

	public BookEntity getbook1() {
		return book1;
	}

	public void setAddress1(BookEntity book1) {
		this.book1 = book1;
	}

	/*
	 * equals generating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book1 == null) ? 0 : book1.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((cust1 == null) ? 0 : cust1.hashCode());
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((reviewId == null) ? 0 : reviewId.hashCode());
		result = prime * result + ((reviewOn == null) ? 0 : reviewOn.hashCode());
		return result;
	}

	/*
	 * equals generating
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewEntity other = (ReviewEntity) obj;
		if (book1 == null) {
			if (other.book1 != null)
				return false;
		} else if (!book1.equals(other.book1))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (cust1 == null) {
			if (other.cust1 != null)
				return false;
		} else if (!cust1.equals(other.cust1))
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
	 * to string generating
	 */
	@Override
	public String toString() {
		return String.format("reviewId=%s, headline=%s, comment=%s, rating=%s,reviewOn=%s,customer=%s,book=%s ",
				reviewId, headline, comment, rating, reviewOn, cust1, book1);
	}

}