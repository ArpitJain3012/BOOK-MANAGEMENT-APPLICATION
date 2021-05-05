package com.capg.bsma.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Linking books Database with entity class BookEntity
 */
@Entity
@Table(name = "books")
public class BookEntity {

	// Primary key in database
	@Id
	@Column(name = "book_Id")
	private Long bookId;

	// title of book
	@Column(name = "title")
	private String title;

	// Writer of the book
	@Column(name = "author")
	private String author;

	// Description of books
	@Column(name = "description")
	private String description;

	// international standard book number
	@Column(name = "isbn")
	private String isbn;

	// price of books
	@Column(name = "price")
	private BigDecimal price;

	// published date of book
	@Column(name = "pub_Date")
	private LocalDate pubDate;

	// last updated date
	@Column(name = "last_Up_Date")
	private LocalDate lastUpDate;

	/*
	 * using many to one association for mapping with category entity
	 */
	@ManyToOne
	@JoinColumn(name = "category_Id")
	private CategoryEntity category;

	/*
	 * using one to many association for mapping with review entity
	 */
	@OneToMany(mappedBy = "book1", cascade = CascadeType.ALL)
	private Set<ReviewEntity> rev;
	/*
	 * using one to many association for mapping with rorder details entity
	 */
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private Set<OrderDetailEntity> orderdetail1;

	// default constructor
	public BookEntity() {
		// no implementation
	}

	// Parametrized constructor
	public BookEntity(Long bookId, String title, String author, String description, String isbn, BigDecimal price,
			LocalDate pubDate, LocalDate lastUpDate, CategoryEntity category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.pubDate = pubDate;
		this.lastUpDate = lastUpDate;
		this.category = category;
	}

	/*
	 * getters and setters
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Set<ReviewEntity> getRev() {
		return rev;
	}

	public void setRev(Set<ReviewEntity> rev) {
		this.rev = rev;
	}

	public Set<OrderDetailEntity> getOrderdetail1() {
		return orderdetail1;
	}

	public void setOrderdetail1(Set<OrderDetailEntity> orderdetail1) {
		this.orderdetail1 = orderdetail1;
	}

	/*
	 * hashcode generating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((lastUpDate == null) ? 0 : lastUpDate.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * equals method generating
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
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
	 * to string method generating
	 */
	@Override
	public String toString() {
		return String.format(
				"bookId=%s , title=%s , author=%s , description=%s , isbn=%s , price=%s , pubDate=%s , lastUpDate=%s,category=%s",
				bookId, title, author, description, isbn, price, pubDate, lastUpDate, category);

	}

}