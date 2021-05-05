package com.capg.bsma.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.AddressModel;
import com.capg.bsma.model.CustomerModel;
import com.capg.bsma.repo.ICustomerRepository;
import com.capg.bsma.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
	AddressModel am = new AddressModel("11B", "Rohini", "INDIA", "110039");
	AddressModel am1 = new AddressModel("22c", "Pitampura", "INDIA", "110035");

	@Mock
	private ICustomerRepository customerrepo;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	private CustomerServiceImpl csImpl;

	/**
	 * Test case - retrieving list of customers
	 */
	@Test
	@DisplayName("ICustomerServiceImpl::listallcustomer should return list of existing customer details from database")
	void testListAllCustomer() throws BMSException {

		// entering mock values into the Entity constructor
		List<CustomerEntity> testdata = Arrays.asList(new CustomerEntity[] {
				new CustomerEntity(8L, "arpit@gmai.com", "Arpit Jain", "arpit1234", "9313666807", LocalDate.now(), am),
				new CustomerEntity(9L, "abhijeet@gmai.com", "Abhijeet singh", "singh1234", "9319273314",
						LocalDate.now().minusDays(1), am1) });

		// find all method is called
		Mockito.when(customerrepo.findAll()).thenReturn(testdata);

		// entering mock values into the Model constructor
		List<CustomerModel> expected = Arrays.asList(new CustomerModel[] {
				new CustomerModel(8L, "arpit@gmai.com", "Arpit Jain", "arpit1234", "9313666807", LocalDate.now(), am),
				new CustomerModel(9L, "abhijeet@gmai.com", "Abhijeet singh", "singh1234", "9319273314",
						LocalDate.now().minusDays(1), am1) });

		List<CustomerModel> actual = csImpl.listCustomers();
		assertEquals(expected, actual);

	}

	/**
	 * Test Case-adding customer details
	 */
	@Test
	@DisplayName("ICustomerServiceImpl::addCustomer should add customers in database")
	void testAddCustomer() throws BMSException {

		// entering mock values into the Entity constructor
		CustomerEntity testdata = new CustomerEntity(8L, "arpit@gmail.com", "Arpit Jain", "arpit1234", "9313666807",
				LocalDate.now(), am);

		// entering mock values into the Model constructor
		CustomerModel expected = new CustomerModel(8L, "arpit@gmail.com", "Arpit Jain", "arpit1234", "9313666807",
				LocalDate.now(), am);

		Mockito.when(customerrepo.existsById(testdata.getCustomerId())).thenReturn(false);

		Mockito.when(customerrepo.save(testdata)).thenReturn(testdata);
		CustomerModel actual = csImpl.addCustomer(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Case- updating customer details
	 */
	@Test
	@DisplayName("ICustomerServiceImpl::update customer should update customer details in database")
	void testUpdateCustomer() throws BMSException {
		// entering mock values into the Entity constructor
		CustomerEntity testdata = new CustomerEntity(8L, "arpit@gmail.com", "Arpit Jain", "arpitjain1234", "9313666807",
				LocalDate.now(), am);
		// entering mock values into the Model constructor
		CustomerModel expected = new CustomerModel(8L, "arpit@gmail.com", "Arpit Jain", "arpitjain1234", "9313666807",
				LocalDate.now(), am);

		Mockito.when(customerrepo.existsById(testdata.getCustomerId())).thenReturn(true);

		Mockito.when(customerrepo.save(testdata)).thenReturn(testdata);
		CustomerModel actual = csImpl.updateCustomer(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test Case-deleting customer details
	 * 
	 * @throws BMSException
	 */
	@Test
	@DisplayName("ICustomerServiceImpl::removecustomer should return list of existing packages as ss")
	void testRemoveCustomer() throws BMSException {
		// entering mock values into the Entity constructor
		CustomerEntity testdata = new CustomerEntity(1L, "arpit@gmai.com", "Arpit Jain", "arpitjain1234", "9313666807",
				LocalDate.now(), am);
		Mockito.when(customerrepo.findById(01L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(customerrepo).deleteById(1L);
		boolean actual = csImpl.deleteCustomer(1L);
		assertTrue(actual);
	}

	/**
	 * Test Case-viewing customer details by id
	 * 
	 * @throws BMSException
	 */
	@Test
	@DisplayName("ICustomerServiceImpl::viewcustomer should return list of existing packages as customermodel ")
	void testViewCustomer() throws BMSException {
		// entering mock values into the Entity constructor
		CustomerEntity testdata = new CustomerEntity(1L, "arpit@gmai.com", "Arpit Jain", "arpitjain1234", "9313666807",
				LocalDate.now(), am);
		// entering mock values into the Model constructor
		CustomerModel expected = new CustomerModel(1L, "arpit@gmai.com", "Arpit Jain", "arpitjain1234", "9313666807",
				LocalDate.now(), am);

		Mockito.when(customerrepo.findById(testdata.getCustomerId())).thenReturn(Optional.of(testdata));
		CustomerModel actual = csImpl.viewCustomer(testdata.getCustomerId());
		assertEquals(expected, actual);

	}

}
