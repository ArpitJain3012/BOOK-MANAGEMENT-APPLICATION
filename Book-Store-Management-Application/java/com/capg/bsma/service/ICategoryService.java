package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.BookModel;
import com.capg.bsma.model.CategoryModel;

public interface ICategoryService {
	public CategoryModel addCategory(CategoryModel catmod) throws BMSException;

	public CategoryModel editCategory(CategoryModel catmod) throws BMSException;

	public List<CategoryModel> viewAllCategories() throws BMSException;

	public boolean removeCategory(Long catid) throws BMSException;
	public CategoryModel viewCategory(Long catid) throws BMSException;
}