package com.capg.bsma.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CategoryModel;
import com.capg.bsma.repo.ICategoryRepository;

import com.capg.bsma.service.CategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
	@Mock
	private ICategoryRepository categoryrepo;

	@InjectMocks /*
					 * injecting category repository marked as @Mock into category service
					 * implementation
					 */
	private CategoryServiceImpl csImpl;

	/**
	 * Test Case- list of all category
	 */
	@Test
	@DisplayName("CategoryServiceImpl::ViewAllCategories should return list of existing book's categories ")
	void testViewAllCategories() throws BMSException {

		List<CategoryEntity> testdata = Arrays.asList(new CategoryEntity[] { new CategoryEntity(103L, "Biography"),
				new CategoryEntity(104L, "Autobiography") });
		Mockito.when(categoryrepo.findAll()).thenReturn(testdata);

		List<CategoryModel> expected = Arrays.asList(
				new CategoryModel[] { new CategoryModel(103L, "Biography"), new CategoryModel(104L, "Autobiography") });

		List<CategoryModel> actual = csImpl.viewAllCategories();
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test Case- add category details
	 */
	@Test
	@DisplayName("CategoryServiceImpl::addCategory should add Categories in database")
	public void testAddCategory() throws BMSException {
		CategoryEntity testdata = new CategoryEntity(102L, "Biography");

		CategoryModel expected = new CategoryModel(102L, "Biography");

		Mockito.when(categoryrepo.existsById(testdata.getCategoryId())).thenReturn(false);

		Mockito.when(categoryrepo.save(testdata)).thenReturn(testdata);
		CategoryModel actual = csImpl.addCategory(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Case- update category details
	 */
	@Test
	@DisplayName("CategoryServiceImpl::editCategory should edit Categories in database")
	public void testEditCategory() throws BMSException {
		CategoryEntity testdata = new CategoryEntity(102L, "Biography");

		CategoryModel expected = new CategoryModel(102L, "Biography");

		Mockito.when(categoryrepo.existsById(testdata.getCategoryId())).thenReturn(true);

		Mockito.when(categoryrepo.save(testdata)).thenReturn(testdata);
		CategoryModel actual = csImpl.editCategory(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Case-remove category details
	 */
	@Test
	@DisplayName("CategoryServiceImpl::removeCategory should remove Category in database")
	void testRemoveCategory() throws BMSException {
		CategoryEntity testdata = new CategoryEntity(104L, "Autobiography");

		Mockito.when(categoryrepo.findById(104L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(categoryrepo).deleteById(104L);
		boolean result = csImpl.removeCategory(104L);
		assertTrue(result);
	}

	/**
	 * Test Case-view category by id
	 */
	@Test
	@DisplayName("ICategoryServiceImpl::viewCATEGORY should return list of existing packages as categorymodel ")
	void testViewCategory() throws BMSException {
		CategoryEntity testdata = new CategoryEntity(104L, "Autobiography");

		CategoryModel expected = new CategoryModel(104L, "Autobiography");

		Mockito.when(categoryrepo.findById(testdata.getCategoryId())).thenReturn(Optional.of(testdata));
		CategoryModel actual = csImpl.viewCategory(testdata.getCategoryId());
		assertEquals(expected, actual);

	}

}
