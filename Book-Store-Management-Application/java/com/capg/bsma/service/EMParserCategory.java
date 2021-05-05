package com.capg.bsma.service;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.model.CategoryModel;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserCategory {

	/*
	 * link entity with model
	 */
	public CategoryEntity parse(CategoryModel source) {
		return source == null ? null : new CategoryEntity(source.getCategoryId(), source.getCategoryName());

	}

	/*
	 * link model with entity
	 */
	public CategoryModel parse(CategoryEntity source) {
		return source == null ? null : new CategoryModel(source.getCategoryId(), source.getCategoryName());
	}
}