package com.capg.bsma.model;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/*
 * customer model for validation of customer entity private members
 */
public class CustomerModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "Customer Id cannot be null")
	private Long customerId;

	@Pattern(regexp = "\"^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email id")
	@NotNull(message = "Email cannot be omitted")
	private String email;

	@NotEmpty(message = "full name cannot be empty")
	@NotNull(message = "full name cannot be null")
	private String fullName;

	@Pattern(regexp = "[a-zA-Z0-9 @_]{8,20}", message = "Inavlid password ")
	@NotNull(message = "Password cannot be null")
	private String password;

	@Pattern(regexp = "[1-9][0-9]{9}", message = "invalid mobile number")
	@NotNull(message = "mobile number cannot be null")
	private String mobileNumber;

	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "join date cannot be a future date")
	private LocalDate registerOn;

	@Valid
	private AddressModel am;

	// default constructor
	public CustomerModel() {
		// no implementation
	}

	// parameter constructor
	public CustomerModel(@NotNull(message = "Customer Id cannot be null") Long customerId,
			@Pattern(regexp = "\"^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email id") @NotNull(message = "Email cannot be omitted") String email,
			@NotEmpty(message = "full name cannot be empty") @NotNull(message = "full name cannot be null") String fullName,
			@Pattern(regexp = "[a-zA-Z0-9 @_]{8,20}", message = "Inavlid password ") @NotNull(message = "Password cannot be null") String password,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "invalid mobile number") @NotNull(message = "mobile number cannot be null") String mobileNumber,
			@PastOrPresent(message = "join date cannot be a future date") LocalDate registerOn,
			@Valid AddressModel am) {
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
	 * generating getters and setters
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
		CustomerModel other = (CustomerModel) obj;
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
	 * to string generating
	 */
	@Override
	public String toString() {
		return String.format(
				"customerId=%s, email=%s, fullName=%s, password=%s, mobileNumber=%s, registerOn=%s,Address=%s",
				customerId, email, fullName, password, mobileNumber, registerOn, am);

	}
}
