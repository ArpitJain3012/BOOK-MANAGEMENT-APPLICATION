package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.model.CategoryModel;
import com.capg.bsma.repo.ICategoryRepository;

@Service
public class EMParserCategory {

	@Autowired
	private ICategoryRepository icr;

	public CategoryEntity parse(CategoryModel source) {
		return source == null ? null : new CategoryEntity(source.getCategoryId(), source.getCategoryName());

	}

	public CategoryModel parse(CategoryEntity source) {
		return source == null ? null : new CategoryModel(source.getCategoryId(), source.getCategoryName());
	}
}