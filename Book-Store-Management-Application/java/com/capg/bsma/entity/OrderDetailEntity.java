package com.capg.bsma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * linking ORDERDETAILS database with OrderDetailEntity
 */
@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetailEntity {

	//primary key
	@Id
	@Column(name = "order_detailid")
	private Long order_detail_Id;

	// quantity of order
	@Column(name = "quantity")
	private Long quantity;
	/*
	 * using many to one association for mapping with book order entity
	 */
	@ManyToOne
	@JoinColumn(name = "order_Id")
	private BookOrderEntity bookorders;
	/*
	 * using many to one association for mapping with book entity
	 */
	@ManyToOne
	@JoinColumn(name = "book_Id")
	private BookEntity book;

	//default constructor
	public OrderDetailEntity() {
		// no implementation
	}

	//Parameter Constructor
	public OrderDetailEntity(Long order_detail_Id, Long quantity, BookOrderEntity bookorders, BookEntity book) {
		super();
		this.order_detail_Id = order_detail_Id;
		this.quantity = quantity;
		this.bookorders = bookorders;
		this.book = book;
	}
	/*
	 * getters and setters generating
	 */

	public Long getOrder_detail_Id() {
		return order_detail_Id;
	}

	public void setOrder_detail_Id(Long order_detail_Id) {
		this.order_detail_Id = order_detail_Id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BookOrderEntity getBookorders() {
		return bookorders;
	}

	public void setBookorders(BookOrderEntity bookorders) {
		this.bookorders = bookorders;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	/*
	 * hashcode generating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookorders == null) ? 0 : bookorders.hashCode());
		result = prime * result + ((order_detail_Id == null) ? 0 : order_detail_Id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderDetailEntity other = (OrderDetailEntity) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (bookorders == null) {
			if (other.bookorders != null)
				return false;
		} else if (!bookorders.equals(other.bookorders))
			return false;
		if (order_detail_Id == null) {
			if (other.order_detail_Id != null)
				return false;
		} else if (!order_detail_Id.equals(other.order_detail_Id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	/*
	 * to string generating
	 */
	@Override
	public String toString() {
		return "OrderDetailEntity [order_detail_Id=" + order_detail_Id + ", quantity=" + quantity + ", bookorders="
				+ bookorders + ", book=" + book + "]";
	}
}
