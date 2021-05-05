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
 * linking bookorder database with BookOrderEntity
 */
@Entity
@Table(name = "BOOKORDER")
public class BookOrderEntity {
	// primary key
	@Id
	@Column(name = "order_Id")
	private Long orderId;

	// order date for book
	@Column(name = "Order_Date", length = 20)
	private LocalDate OrderDate;

	// order total for book
	@Column(name = "Order_Total", length = 20)
	private BigDecimal OrderTotal;

	// status of order( example="pending")..
	@Column(name = "status", length = 20)
	private String status;

	// payment method like online or C.O.D
	@Column(name = "payment_Method", length = 10)
	private String paymentMethod;

	// customers phone number
	@Column(name = "recip_phone")
	private String recipientphone;

	// customers name
	@Column(name = "recip_Name")
	private String recipientName;

	/*
	 * using many to one association for mapping with customer entity
	 */
	@ManyToOne
	@JoinColumn(name = "customer_Id")
	private CustomerEntity cust;
	/*
	 * using one to many association for mapping with order details entity
	 */
	@OneToMany(mappedBy = "bookorders", cascade = CascadeType.ALL)
	private Set<OrderDetailEntity> orderdetail;

	// default constructor
	public BookOrderEntity() {
		// no implementation
	}

	// parameterized constructor
	public BookOrderEntity(Long orderId, LocalDate orderDate, BigDecimal orderTotal, String status,
			String paymentMethod, String recipientphone, String recipientName, CustomerEntity cust) {
		super();
		this.orderId = orderId;
		OrderDate = orderDate;
		OrderTotal = orderTotal;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.recipientphone = recipientphone;
		this.recipientName = recipientName;
		this.cust = cust;
	}
	/*
	 * getters and setters
	 */

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public LocalDate getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}

	public BigDecimal getOrderTotal() {
		return OrderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		OrderTotal = orderTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRecipientphone() {
		return recipientphone;
	}

	public void setRecipientphone(String recipientphone) {
		this.recipientphone = recipientphone;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public CustomerEntity getCust() {
		return cust;
	}

	public void setCust(CustomerEntity cust) {
		this.cust = cust;
	}

	public Set<OrderDetailEntity> getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(Set<OrderDetailEntity> orderdetail) {
		this.orderdetail = orderdetail;
	}

	/*
	 * hashcode generating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderDate == null) ? 0 : OrderDate.hashCode());
		result = prime * result + ((OrderTotal == null) ? 0 : OrderTotal.hashCode());
		result = prime * result + ((cust == null) ? 0 : cust.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((recipientName == null) ? 0 : recipientName.hashCode());
		result = prime * result + ((recipientphone == null) ? 0 : recipientphone.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BookOrderEntity other = (BookOrderEntity) obj;
		if (OrderDate == null) {
			if (other.OrderDate != null)
				return false;
		} else if (!OrderDate.equals(other.OrderDate))
			return false;
		if (OrderTotal == null) {
			if (other.OrderTotal != null)
				return false;
		} else if (!OrderTotal.equals(other.OrderTotal))
			return false;
		if (cust == null) {
			if (other.cust != null)
				return false;
		} else if (!cust.equals(other.cust))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (recipientName == null) {
			if (other.recipientName != null)
				return false;
		} else if (!recipientName.equals(other.recipientName))
			return false;
		if (recipientphone == null) {
			if (other.recipientphone != null)
				return false;
		} else if (!recipientphone.equals(other.recipientphone))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	/*
	 * to string generating
	 */
	@Override
	public String toString() {
		return String.format(

				"orderId=%s  , OrderDate=%s ,  OrderDate=%s , OrderTotal=%s , OrderTotal=%s , status=%s,custome=%s",
				orderId, OrderDate, OrderDate, OrderTotal, OrderTotal, status, cust);

	}

}
