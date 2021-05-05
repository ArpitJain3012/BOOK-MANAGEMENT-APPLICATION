package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CategoryModel;

public interface ICategoryService {
	// add category in database
	public CategoryModel addCategory(CategoryModel catmod) throws BMSException;

	// update category in database
	public CategoryModel editCategory(CategoryModel catmod) throws BMSException;

	// list category from database
	public List<CategoryModel> viewAllCategories() throws BMSException;

	// delete category in database
	public boolean removeCategory(Long catid) throws BMSException;

	// view category in database by id
	public CategoryModel viewCategory(Long catid) throws BMSException;
}