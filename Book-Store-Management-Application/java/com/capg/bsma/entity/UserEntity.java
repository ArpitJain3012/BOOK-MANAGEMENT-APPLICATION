package com.capg.bsma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * linking users database with UserEntity
 */
@Entity
@Table(name = "users")
public class UserEntity {

	// primary key
	@Id
	@Column(name = "user_Id")
	private Long userId;

	// email id of customer
	@Column(name = "email", length = 30)
	private String email;

	// password of customer
	@Column(name = "password", length = 20)
	private String password;

	// role of customer
	@Column(name = "role", length = 10)
	private String role;

	@OneToOne
	@JoinColumn(name = "customer_Id")
	private CustomerEntity customer;

	// default constructor
	public UserEntity() {
		/* Intentionally left blank */
	}

	// parameter constructor
	public UserEntity(Long userId, String email, String password, String role, CustomerEntity customer) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.role = role;
		this.customer = customer;
	}
	/*
	 * setters and getters generating
	 */

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	/*
	 * hashcode generating
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * equals mathod generating
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/*
	 * to string generating
	 */

	@Override
	public String toString() {
		return String.format("userId=%s, email=%s, password=%s, role=%s, customer=%s", userId, email, password, role,
				customer);
	}

}
