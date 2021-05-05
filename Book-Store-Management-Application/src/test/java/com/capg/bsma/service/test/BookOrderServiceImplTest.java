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

import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.AddressModel;
import com.capg.bsma.model.BookOrderModel;
import com.capg.bsma.repo.IBookOrderRepository;
import com.capg.bsma.service.BookOrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookOrderServiceImplTest {
	@Mock
	private IBookOrderRepository ibor;

	@InjectMocks
	/*
	 * injecting book repository marked as @Mock into book service implementation
	 */

	private BookOrderServiceImpl bosImpl;

	/**
	 * Test Case- list of book order details
	 */

	@Test
	@DisplayName("IBookOrderServiceImpl::ListAllBooksorder should return list of existing book order details from database")
	void testListAllBooksorder() throws BMSException {
		BigDecimal b = new BigDecimal("5000");
		List<BookOrderEntity> testdata = Arrays.asList(new BookOrderEntity[] {

				new BookOrderEntity(101L, LocalDate.now(), b, "Delivered", "Cash", "8586868626", "Rahul",
						new CustomerEntity()),
				new BookOrderEntity(102L, LocalDate.now(), b, "Pending", "Credit Card", "8798858545", "Aman",
						new CustomerEntity()) });

		Mockito.when(ibor.findAll()).thenReturn(testdata);

		List<BookOrderModel> expected = Arrays.asList(new BookOrderModel[] {
				new BookOrderModel(101L, null, LocalDate.now(), b, "Delivered", "Cash", "8586868626", "Rahul"),
				new BookOrderModel(102L, null, LocalDate.now(), b, "Pending", "Credit Card", "8798858545", "Aman") });

		List<BookOrderModel> actual = bosImpl.listAllBookOrder();

		assertEquals(expected, actual);

	}

	/**
	 * Test Case- delete book order details
	 */

	@Test
	@DisplayName("IBookOrderServiceImpl::deleteBookOrder should return list of existing packages as ss")
	void testdeleteBookOrder() throws BMSException {
		BigDecimal b = new BigDecimal("5000");
		BookOrderEntity testdata = new BookOrderEntity(101L, LocalDate.now(), b, "Delivered", "Cash", "8586868626",
				"Rahul", new CustomerEntity());
		Mockito.when(ibor.findById(101L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(ibor).deleteById(101L);

		boolean actual = bosImpl.deleteBookOrder(101L);
		assertTrue(actual);
	}

	/**
	 * Test Case- view book order details by particular id
	 */

	@Test
	@DisplayName("IBookOrderServiceImpl::viewcustomer should return list of existing packages as bookordermodel ")
	void testViewBookOrder() throws BMSException {
		BigDecimal b = new BigDecimal("5000");
		BookOrderEntity testdata = new BookOrderEntity(101L, LocalDate.now(), b, "Delivered", "Cash", "8586868626",
				"Rahul", new CustomerEntity());
		BookOrderModel expected = new BookOrderModel(101L, null, LocalDate.now(), b, "Delivered", "Cash", "8586868626",
				"Rahul");

		Mockito.when(ibor.findById(testdata.getOrderId())).thenReturn(Optional.of(testdata));
		BookOrderModel actual = bosImpl.viewBookOrder(testdata.getOrderId());
		assertEquals(expected, actual);

	}
}
