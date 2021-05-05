package com.capg.bsma.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class BookModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "book id cannot be null")
	@NotBlank(message = "book id cannot be blank")
	private Long bookId;

	@NotNull(message = "book id cannot be null")
	@NotBlank(message = "book id cannot be blank")
	private Long categoryId;

	@NotNull(message = "title cannot be null")
	private String title;

	@NotNull(message = "author cannot be null")
	private String author;

	@NotNull(message = "description cannot be null")
	private String description;

	@NotNull(message = "isbn cannot be null")
	private String isbn;

	@NotNull(message = "price cannot be null")
	private BigDecimal price;

	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "publish date cannot be a future date")
	private LocalDate pubDate;

	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "lastUpdated on date cannot be a future date")
	private LocalDate lastUpDate;

//default constructor 
	public BookModel() {
		// no implementation
	}

	/*
	 * generating constructors using fields
	 */
	public BookModel(
			@NotNull(message = "book id cannot be null") @NotBlank(message = "book id cannot be blank") Long bookId,
			@NotNull(message = "book id cannot be null") @NotBlank(message = "book id cannot be blank") Long categoryId,
			@NotNull(message = "title cannot be null") String title,
			@NotNull(message = "author cannot be null") String author,
			@NotNull(message = "description cannot be null") String description,
			@NotNull(message = "isbn cannot be null") String isbn,
			@NotNull(message = "price cannot be null") BigDecimal price,
			@PastOrPresent(message = "publish date cannot be a future date") LocalDate pubDate,
			@PastOrPresent(message = "lastUpdated on date cannot be a future date") LocalDate lastUpDate) {
		super();
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.pubDate = pubDate;
		this.lastUpDate = lastUpDate;
	}

	/*
	 * generating getters and setters
	 */
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public LocalDate getLastUpDate() {
		return lastUpDate;
	}

	public void setLastUpDate(LocalDate lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/*
	 * generating hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((lastUpDate == null) ? 0 : lastUpDate.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BookModel other = (BookModel) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (lastUpDate == null) {
			if (other.lastUpDate != null)
				return false;
		} else if (!lastUpDate.equals(other.lastUpDate))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (pubDate == null) {
			if (other.pubDate != null)
				return false;
		} else if (!pubDate.equals(other.pubDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/*
	 * generating to string 
	 */
	@Override
	public String toString() {
		return String.format(
				"bookId=%s , title=%s , author=%s , description=%s , isbn=%s , price=%s , pubDate=%s , lastUpDate=%s,categoryid=%s",
				bookId, title, author, description, isbn, price, pubDate, lastUpDate, categoryId);
	}

}