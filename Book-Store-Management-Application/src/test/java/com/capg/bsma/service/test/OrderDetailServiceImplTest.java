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
import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.entity.OrderDetailEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.OrderDetailsModel;
import com.capg.bsma.repo.IOrderDetailRepository;
import com.capg.bsma.service.OrderDetailServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderDetailServiceImplTest {
	CategoryEntity cat = new CategoryEntity(104L, "History");
	BigDecimal b = new BigDecimal("544");
	@Mock
	private IOrderDetailRepository iodr;

	@InjectMocks
	/*
	 * injecting orderDetail repository marked as @Mock into orderDetail service
	 * implementation
	 */
	private OrderDetailServiceImpl odsImpl;

	/**
	 * Test Case- list of order details
	 */
	@Test
	@DisplayName("OrderDetailServiceImpl::listOfOrderDetail should return list of existing book's order details")
	void testListOfOrderDetail() throws BMSException {

		List<OrderDetailEntity> testdata = Arrays.asList(new OrderDetailEntity[] { new OrderDetailEntity(20004L, 10L,
				new BookOrderEntity(101L, LocalDate.now(), b, "Delivered", "Cash", "8586868626", "Rahul",
						new CustomerEntity()),
				new BookEntity(202L, "Unfinished", "Priyanka Chopra", "collection of her life experiences",
						"3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now(), cat)) });
		Mockito.when(iodr.findAll()).thenReturn(testdata);

		List<OrderDetailsModel> expected = Arrays
				.asList(new OrderDetailsModel[] { new OrderDetailsModel(20004L, 10L, 202L, 101L) });

		List<OrderDetailsModel> actual = odsImpl.listOfOrderDetail();
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test Case- deleting order details
	 */
	@Test
	@DisplayName("OrderDetailServiceImpl::deleteOrderDetail should return list of existing book order details ")
	public void testDeleteOrderDetail() throws BMSException {

		OrderDetailEntity testdata = new OrderDetailEntity(20004L, 3L, new BookOrderEntity(), new BookEntity());
		Mockito.when(iodr.findById(20004L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(iodr).deleteById(20004L);
		boolean result = (odsImpl).deleteOrderDetail(20004L);
		assertTrue(result);
	}

	/**
	 * Test Case- viewing order details by id
	 */
	@Test
	@DisplayName("OrderDetailServiceImpl::viewOrderDetails should return list of existing OrderDetails ")

	void testViewOrderDetails() throws BMSException {

		OrderDetailEntity testdata = new OrderDetailEntity(20004L, 10L,
				new BookOrderEntity(101L, LocalDate.now(), b, "Delivered", "Cash", "8586868626", "Rahul",
						new CustomerEntity()),
				new BookEntity(202L, "Unfinished", "Priyanka Chopra", "collection of her life experiences",
						"3456789987621", b, LocalDate.now().minusDays(1), LocalDate.now(), cat));
		OrderDetailsModel expected = new OrderDetailsModel(20004L, 10L, 202L, 101L);

		Mockito.when(iodr.findById(20004L)).thenReturn(Optional.of(testdata));
		OrderDetailsModel actual = odsImpl.viewOrderDetails(20004L);
		assertEquals(expected, actual);

	}

}
