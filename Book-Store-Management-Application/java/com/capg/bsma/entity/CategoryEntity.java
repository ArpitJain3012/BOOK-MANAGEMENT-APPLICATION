package com.capg.bsma.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * linking category database with CategoryEntity
 */
@Entity
@Table(name = "category")
public class CategoryEntity {

	// primary key
	@Id
	@Column(name = "category_Id")
	private Long categoryId;

	// book category name
	@Column(name = "category_Name")
	private String categoryName;

	/*
	 * using one to many association for mapping with book entity
	 */
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<BookEntity> book;

	// default constructor
	public CategoryEntity() {
		// no implementation

	}

	// parametrized constructor
	public CategoryEntity(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	/*
	 * getters and setters
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

	public Set<BookEntity> getBook() {
		return book;
	}

	public void setBook(Set<BookEntity> book) {
		this.book = book;
	}

	/*
	 * hashcode generating
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
		CategoryEntity other = (CategoryEntity) obj;
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
	 * to string generating
	 */
	@Override
	public String toString() {
		return String.format("categoryId=%s ,categoryName=%s", categoryId, categoryName);
	}

}