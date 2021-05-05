package com.capg.bsma.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CategoryModel;
import com.capg.bsma.service.CategoryServiceImpl;

@RestController
@RequestMapping(path = "/category")
public class CategoryAPI {
	@Autowired
	private CategoryServiceImpl catService;

	/*
	 * list of all categories
	 */
	@GetMapping
	public ResponseEntity<List<CategoryModel>> viewAllCategoriesAction() throws BMSException {
		return new ResponseEntity<>(catService.viewAllCategories(), HttpStatus.OK);
	}

	/*
	 * adding category data
	 */
	@PostMapping
	public ResponseEntity<CategoryModel> addCategoryAction(@RequestBody CategoryModel cat) throws BMSException {
		cat = catService.addCategory(cat);
		return new ResponseEntity<>(cat, HttpStatus.CREATED);
	}

	/*
	 * updating categories
	 */
	@PutMapping
	public ResponseEntity<CategoryModel> editCategoryAction(@RequestBody CategoryModel cat) throws BMSException {
		cat = catService.editCategory(cat);
		return new ResponseEntity<>(cat, HttpStatus.OK);
	}
	/*
	 * deleting category data by category id
	 */

	@DeleteMapping("/{catId}")
	public ResponseEntity<Boolean> removeCategoryAction(@PathVariable("catId") Long catId) throws BMSException {
		Boolean res = catService.removeCategory(catId);
		ResponseEntity<Boolean> response1 = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response1;
	}

	/*
	 * finding category by id
	 */
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryModel> findByCategoryIdAction(@PathVariable("catId") Long cId) throws BMSException {
		return ResponseEntity.ok(catService.viewCategory(cId));
	}
}
