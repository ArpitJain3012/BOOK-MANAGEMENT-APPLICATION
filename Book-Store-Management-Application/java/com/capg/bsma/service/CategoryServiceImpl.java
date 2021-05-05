package com.capg.bsma.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CategoryModel;
import com.capg.bsma.repo.ICategoryRepository;

/*
 * implementing service method for category
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository catrepo;

	@Autowired
	private EMParserCategory parser;

	// default constructor
	public CategoryServiceImpl() {
		this.parser = new EMParserCategory();
	}

	// parameter constructor
	public CategoryServiceImpl(ICategoryRepository catrepo) {
		super();
		this.catrepo = catrepo;
		this.parser = new EMParserCategory();
	}

	@Transactional
	@Override
	/*
	 * addCategory should add categories in database
	 */
	public CategoryModel addCategory(CategoryModel catmod) throws BMSException {

		if (catmod != null) {
			if (catrepo.existsById(catmod.getCategoryId())) {
				throw new BMSException("category with this id already exists");
			}

			catmod = parser.parse(catrepo.save(parser.parse(catmod)));
		}

		return catmod;
	}

	@Transactional
	@Override
	/*
	 * editCategory should edit categories in database
	 */

	public CategoryModel editCategory(CategoryModel catmod) throws BMSException {

		if (catmod != null) {
			if (!catrepo.existsById(catmod.getCategoryId())) {
				throw new BMSException("No categories in the list");
			}

			catmod = parser.parse(catrepo.save(parser.parse(catmod)));
		}

		return catmod;

	}

	@Override
	/*
	 * viewAllCategory should view all categories in database
	 */
	public List<CategoryModel> viewAllCategories() throws BMSException {

		return catrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

	@Transactional
	@Override
	/*
	 * removeCategory should remove categories in database
	 */
	public boolean removeCategory(Long catid) throws BMSException {
		CategoryEntity cat = catrepo.findById(catid).orElse(null);
		if (cat == null) {
			throw new BMSException("No Such Book Found");
		} else {
			catrepo.deleteById(catid);
		}
		return true;
	}

	@Override
	/*
	 * viewcategory should return list of existing category
	 */
	public CategoryModel viewCategory(Long catid) throws BMSException {
		CategoryEntity book = catrepo.findById(catid).orElse(null);
		if (book == null) {
			throw new BMSException("No book found for given id : " + catid);
		}
		return parser.parse(catrepo.findById(catid).get());
	}

}