package com.capg.bsma.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
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

import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.entity.ReviewEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.AddressModel;
import com.capg.bsma.model.ReviewModel;
import com.capg.bsma.repo.IReviewRepository;
import com.capg.bsma.service.ReviewServiceImpl;

@ExtendWith(MockitoExtension.class)

public class ReviewServiceImplTest {
	AddressModel am = new AddressModel("11B", "Rohini", "INDIA", "110039");
	BigDecimal b = new BigDecimal("544");
	CategoryEntity cat = new CategoryEntity(104L, "History");

	@Mock
	private IReviewRepository reviewrepo;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	private ReviewServiceImpl rsImpl;

	/**
	 * Test Case - listing/Retrieving all the reviews
	 */
	@Test
	@DisplayName("ReviewServiceImpl::listallreviews should return list of existing reviews  from database")
	void testListAllReview() throws BMSException {

		List<ReviewEntity> testdata = Arrays.asList(new ReviewEntity[] {
				new ReviewEntity(101L, "Best Book ever", "Can'nt believe I bought it", "5 star", LocalDate.now(),
						new CustomerEntity(8L, "arpit@gmai.com", "Arpit Jain", "arpit1234", "9313666807",
								LocalDate.now(), am),
						new BookEntity(202L, "Unfinished", "Priyanka Chopra", "collection of her life experiences",
								"3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now(), cat)) });
		/* when repo.findAll() is called, then test data */
		Mockito.when(reviewrepo.findAll()).thenReturn(testdata);

		List<ReviewModel> expected = Arrays.asList(new ReviewModel[] { new ReviewModel(101L, 8L, 202L, "Best Book ever",
				"Can'nt believe I bought it", "5 star", LocalDate.now()) });
		List<ReviewModel> actual = rsImpl.listAllReviews();

		assertEquals(expected, actual);

	}

	/**
	 * Test Case - removing/deleting all the reviews
	 */
	@Test
	@DisplayName("ReviewServiceImpl::removereview should return list of existing packages as ss")
	void testRemoveReview() throws BMSException {
		ReviewEntity testdata = new ReviewEntity(101L, "So cool", "Must Read for all", "4 star", LocalDate.now(),
				new CustomerEntity(), new BookEntity());

		Mockito.when(reviewrepo.findById(101L)).thenReturn(Optional.of(testdata));
		boolean actual = rsImpl.deleteReview(101L);
		assertTrue(actual);
	}

	/**
	 * Test Case - viewing all the reviews
	 */
	@Test
	@DisplayName("ReviewServiceImpl::viewreview should return list of existing packages as reviewmodel ")
	void testViewReview() throws BMSException {
		ReviewEntity testdata = new ReviewEntity(101L, "Best Book ever", "Can'nt believe I bought it", "5 star",
				LocalDate.now(),
				new CustomerEntity(8L, "arpit@gmai.com", "Arpit Jain", "arpit1234", "9313666807", LocalDate.now(), am),
				new BookEntity(202L, "Unfinished", "Priyanka Chopra", "collection of her life experiences",
						"3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now(), cat));
		ReviewModel expected = new ReviewModel(101L, 8L, 202L, "Best Book ever", "Can'nt believe I bought it", "5 star",
				LocalDate.now());

		Mockito.when(reviewrepo.findById(testdata.getReviewId())).thenReturn(Optional.of(testdata));
		ReviewModel actual = rsImpl.viewReview(testdata.getReviewId());
		assertEquals(expected, actual);

	}

}