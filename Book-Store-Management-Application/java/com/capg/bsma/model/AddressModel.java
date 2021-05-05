package com.capg.bsma.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/*
 * addressmodel class use to embedding address data into customer 
 */
@Embeddable
public class AddressModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "House No. cannot be null")
	private String houseno;

	@NotNull(message = "City name cannot be null")
	private String city;

	@NotNull(message = "Country name cannot be null")
	private String country;

	@NotNull(message = "Pincode cannot be null")
	@Pattern(regexp = "[a-zA-Z0-9]{1,6}", message = "Invalid Pincode")
	private String pincode;

	//default constructor
	public AddressModel() {
		// no implementation
	}

	/*
	 * generating constructors using field
	 */
	public AddressModel(@NotNull(message = "House No. cannot be null") String houseno,
			@NotNull(message = "City name cannot be null") String city,
			@NotNull(message = "Country name cannot be null") String country,
			@NotNull(message = "Pincode cannot be null") @Pattern(regexp = "[a-zA-Z0-9]{1,6}", message = "Invalid Pincode") String pincode) {
		super();
		this.houseno = houseno;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	/*
	 * generating getters and setters
	 */
	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/*
	 * generating hashCodes method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((houseno == null) ? 0 : houseno.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
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
		AddressModel other = (AddressModel) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (houseno == null) {
			if (other.houseno != null)
				return false;
		} else if (!houseno.equals(other.houseno))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		return true;
	}

	/*
	 * generating to string
	 */
	@Override
	public String toString() {
		return String.format("Houseno=%s, city=%s, country=%s, pincode=%s", houseno, city, country, pincode);
	}
}
