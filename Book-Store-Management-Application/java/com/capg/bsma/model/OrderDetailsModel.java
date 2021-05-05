package com.capg.bsma.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderDetailsModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "order detail id cannot be null")
	@NotBlank(message = "order detail id cannot be blank")
	private Long order_detail_Id;

	@NotNull(message = "quantity cannot be null")
	private Long quantity;

	@NotNull(message = "order id cannot be null")
	private Long bookorder_id;

	@NotNull(message = "book id cannot be null")
	private Long book_Id;

	// default constructor
	public OrderDetailsModel() {
		// no implementation
	}

	// parameter constructor
	public OrderDetailsModel(
			@NotNull(message = "order detail id cannot be null") @NotBlank(message = "order detail id cannot be blank") Long order_detail_Id,
			@NotNull(message = "quantity cannot be null") Long quantity,
			@NotNull(message = "order id cannot be null") Long bookorder_id,
			@NotNull(message = "book id cannot be null") Long book_Id) {
		super();
		this.order_detail_Id = order_detail_Id;
		this.quantity = quantity;
		this.bookorder_id = bookorder_id;
		this.book_Id = book_Id;
	}

	/*
	 * generating getters and setters
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

	public Long getBookorder_id() {
		return bookorder_id;
	}

	public void setBookorder_id(Long bookorder_id) {
		this.bookorder_id = bookorder_id;
	}

	public Long getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(Long book_Id) {
		this.book_Id = book_Id;
	}

	/*
	 * hashcode generating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_Id == null) ? 0 : book_Id.hashCode());
		result = prime * result + ((bookorder_id == null) ? 0 : bookorder_id.hashCode());
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
		OrderDetailsModel other = (OrderDetailsModel) obj;
		if (book_Id == null) {
			if (other.book_Id != null)
				return false;
		} else if (!book_Id.equals(other.book_Id))
			return false;
		if (bookorder_id == null) {
			if (other.bookorder_id != null)
				return false;
		} else if (!bookorder_id.equals(other.bookorder_id))
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
		return "OrderDetailsModel [order_detail_Id=" + order_detail_Id + ", quantity=" + quantity + ", bookorder_id="
				+ bookorder_id + ", book_id=" + book_Id + "]";
	}

}
