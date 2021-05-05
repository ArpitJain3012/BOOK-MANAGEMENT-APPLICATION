package com.capg.bsma.model;

import java.math.BigDecimal;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class BookOrderModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = " order Id cannot be null")
	@NotBlank(message = "orderId cannot be blank")
	private Long orderId;

	@NotNull(message = " order Id cannot be null")
	@NotBlank(message = "orderId cannot be blank")
	private Long custId;

	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "OrderDate cannot be a future date")
	private LocalDate OrderDate;

	@NotNull(message = " order Total cannot be null")
	private BigDecimal OrderTotal;

	@NotEmpty(message = "status cannot be null")
	@NotNull(message = "status cannot be null")
	private String status;

	@NotEmpty(message = "paymentMethod cannot be null")
	@NotNull(message = "paymentMethod cannot be null")
	private String paymentMethod;

	@Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid recipientphone")
	@NotNull(message = "recipientphone cannot be null")
	private String recipientphone;

	@NotEmpty(message = "recipientName cannot be null")
	@NotNull(message = "recipientName cannot be null")
	private String recipientName;

	// default constructor
	public BookOrderModel() {
		// no implementation
	}

	// parameter constructor
	public BookOrderModel(
			@NotNull(message = " order Id cannot be null") @NotBlank(message = "orderId cannot be blank") Long orderId,
			@NotNull(message = " order Id cannot be null") @NotBlank(message = "orderId cannot be blank") Long custId,
			@PastOrPresent(message = "OrderDate cannot be a future date") LocalDate orderDate,
			@NotNull(message = " order Total cannot be null") BigDecimal orderTotal,
			@NotEmpty(message = "status cannot be null") @NotNull(message = "status cannot be null") String status,
			@NotEmpty(message = "paymentMethod cannot be null") @NotNull(message = "paymentMethod cannot be null") String paymentMethod,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid recipientphone") @NotNull(message = "recipientphone cannot be null") String recipientphone,
			@NotEmpty(message = "recipientName cannot be null") @NotNull(message = "recipientName cannot be null") String recipientName) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		OrderDate = orderDate;
		OrderTotal = orderTotal;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.recipientphone = recipientphone;
		this.recipientName = recipientName;
	}

	/*
	 * generating getters and setters
	 */
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	/*
	 * hashcode genrating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderDate == null) ? 0 : OrderDate.hashCode());
		result = prime * result + ((OrderTotal == null) ? 0 : OrderTotal.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((recipientName == null) ? 0 : recipientName.hashCode());
		result = prime * result + ((recipientphone == null) ? 0 : recipientphone.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BookOrderModel other = (BookOrderModel) obj;
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
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
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
				"orderId=%s,  status=%s,   paymentMethod=%s, recipientphone=%s, recipientName=%s,customerId=%s ",
				orderId, status, paymentMethod, recipientphone, recipientName, custId);
	}
}
