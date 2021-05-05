package com.capg.bsma.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryModel {

	/*
	 * validations for all private members
	 */
	@NotNull(message = "category id cannot be null")
	@NotBlank(message = "book id cannot be blank")
	private Long categoryId;

	@NotNull(message = "category name cannot be null")
	private String categoryName;

	// default constructor
	public CategoryModel() {
		// no implementation
	}

	// parametrized constructor
	public CategoryModel(
			@NotNull(message = "category id cannot be null") @NotBlank(message = "book id cannot be blank") Long categoryId,
			@NotNull(message = "category name cannot be null") String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	/*
	 * generating getters and setters
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/*
	 * generating hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
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
		CategoryModel other = (CategoryModel) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}

	/*
	 * generating to string
	 */
	@Override
	public String toString() {
		return String.format("categoryId=%s ,categoryName=%s", categoryId, categoryName);
	}

}
