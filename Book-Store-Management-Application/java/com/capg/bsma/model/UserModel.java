package com.capg.bsma.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "user id cannot be null")
	@NotBlank(message = "user id cannot be blank")
	private Long userId;

	@Pattern(regexp = "\"^[a-zA-Z0-9_!#$%&'*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email id")
	@NotNull(message = "Email cannot be null")
	private String email;

	@Pattern(regexp = "[a-zA-Z0-9!@_]{8,20}", message = "Invalid password")
	@NotNull(message = "Password cannot be null")
	private String password;

	@NotNull(message = "role cannot be null")
	@NotEmpty(message = "role cannot be blank")
	private String role;

	// default constructor
	public UserModel() {
		// Intentionally left blank
	}

	// parametrized constructor
	public UserModel(
			@NotNull(message = "user id cannot be null") @NotBlank(message = "user id cannot be blank") Long userId,
			@Pattern(regexp = "\"^[a-zA-Z0-9_!#$%&'*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email id") @NotNull(message = "Email cannot be null") String email,
			@Pattern(regexp = "[a-zA-Z0-9!@_]{8,20}", message = "Invalid password") @NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "role cannot be null") @NotEmpty(message = "role cannot be blank") String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	/*
	 * generating getters and setters
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

	/*
	 * generating hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserModel other = (UserModel) obj;
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
	 * generating to string
	 */

	@Override
	public String toString() {
		return String.format("userId=%s, email=%s, password=%s, role=%s", userId, email, password, role);
	}

}
