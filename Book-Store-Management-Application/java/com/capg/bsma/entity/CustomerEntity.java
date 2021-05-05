package com.capg.bsma.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capg.bsma.model.AddressModel;
/*
 * linking customer database with CustomerEntity
 */
@Entity
@Table(name = "customer")
public class CustomerEntity {
	//primary key
	@Id
	@Column(name = "customer_Id")
	private Long customerId;

	// email id of customer
	@Column(name = "email", length = 30)
	private String email;

	// full name of customer
	@Column(name = "full_name", length = 20)
	private String fullName;

	//passowrd for email id
	@Column(name = "password", length = 20)
	private String password;

	//contact number
	@Column(name = "mobile_Number", length = 10)
	private String mobileNumber;

	//registration date on application
	@Column(name = "register_On")
	private LocalDate registerOn;
	/*
	 * embedding address model class in customer
	 */
	@Embedded
	private AddressModel am;
	/*
	 * using one to many association for mapping with BookOrders entity
	 */

	@OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
	private Set<BookOrderEntity> bo;

	/*
	 * using one to many association for mapping with review entity
	 * 
	 */
	@OneToMany(mappedBy = "cust1", cascade = CascadeType.ALL)
	private Set<ReviewEntity> rev;

	//default constructor
	public CustomerEntity() {
		// no implementation
	}

	//Parameter Constructor
	public CustomerEntity(Long customerId, String email, String fullName, String password, String mobileNumber,
			LocalDate registerOn, AddressModel am) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.registerOn = registerOn;
		this.am = am;
	}

	/*
	 * getters and setters generating
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getRegisterOn() {
		return registerOn;
	}

	public void setRegisterOn(LocalDate registerOn) {
		this.registerOn = registerOn;
	}

	public AddressModel getAm() {
		return am;
	}

	public void setAm(AddressModel am) {
		this.am = am;
	}

	public Set<BookOrderEntity> getBo() {
		return bo;
	}

	public void setBo(Set<BookOrderEntity> bo) {
		this.bo = bo;
	}

	public Set<ReviewEntity> getRev() {
		return rev;
	}

	public void setRev(Set<ReviewEntity> rev) {
		this.rev = rev;
	}
	/*
	 * hashcode generating
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((am == null) ? 0 : am.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registerOn == null) ? 0 : registerOn.hashCode());
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
		CustomerEntity other = (CustomerEntity) obj;
		if (am == null) {
			if (other.am != null)
				return false;
		} else if (!am.equals(other.am))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registerOn == null) {
			if (other.registerOn != null)
				return false;
		} else if (!registerOn.equals(other.registerOn))
			return false;
		return true;
	}

	/*
	 * . to string generating
	 */
	@Override
	public String toString() {
		return String.format(
				"customerId=%s, email=%s, fullName=%s, password=%s, mobileNumber=%s, registerOn=%s,Address=%s",
				customerId, email, fullName, password, mobileNumber, registerOn, am);

	}

}
