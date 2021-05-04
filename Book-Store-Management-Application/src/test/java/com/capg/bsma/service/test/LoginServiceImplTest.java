package com.capg.bsma.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CategoryEntity;
import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.CategoryModel;
import com.capg.bsma.model.UserModel;
import com.capg.bsma.repo.ILoginRepository;
import com.capg.bsma.service.LoginServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class LoginServiceImplTest {

	@Mock
	private ILoginRepository userrepo;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	private LoginServiceImpl lsImpl;

	/**
	 * Test Case 1 - adding users in the book store.
	 */
	@Test
	@DisplayName("LoginServiceImpl::addUser should add users in database")
	void testAddUser() throws BMSException {

		UserEntity testdata = new UserEntity(101L, "arpit@gmail.com", "arpit1234", "President");
		UserModel expected = new UserModel(101L, "arpit@gmai.com", "arpit1234", "President");

		/* when userrepo.save() is called with test data */
		Mockito.when(userrepo.save(testdata)).thenReturn(testdata);
		UserModel actual = lsImpl.addUser(expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test Case 2 - deleting/removing user from the book store
	 */
	@Test
	@DisplayName("LoginServiceImpl::removeuser should return list of existing packages as ss")
	void testRemoveUser() throws BMSException {
		UserEntity testdata = new UserEntity(101L, "arpit@gmail.com", "arpitjain1234", "President");
		UserModel expected = new UserModel(101L, "arpit@gmail.com", "arpitjain1234", "President");

		Mockito.when(userrepo.findById(101L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(userrepo).deleteById(101L);

		boolean actual = lsImpl.removedUser(101L);
		assertTrue(actual);
	}

	/**
	 * Test Case 3- updating user info in the book store
	 */
	@Test
	@DisplayName("LoginServiceImpl::update user should update user details in database")
	void testUpdateUser() throws BMSException {
		UserEntity testdata = new UserEntity(101L, "arpit@gmail.com", "arpitjain1235", "Vice-President");
		UserModel expected = new UserModel(101L, "arpit@gmail.com", "arpitjain1235", "Vice-President");

		Mockito.when(userrepo.save(testdata)).thenReturn(testdata);
		UserModel actual = lsImpl.updateUser(expected);
		assertEquals(expected, actual);

	}
	/**
	 * Test Case 4 -view user by id
	 */
	@Test
	@DisplayName("ILoginServiceImpl::method dhoul return user by id ")
	void testViewUser() throws BMSException {
		UserEntity testdata = new UserEntity(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President");
		UserModel expected = new UserModel(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President");

		Mockito.when(userrepo.findById(testdata.getUserId())).thenReturn(Optional.of(testdata));
		UserModel actual = lsImpl.getById(testdata.getUserId());
		assertEquals(expected, actual);

	}
	/**
	 * Test Case 4 -view user by id
	 */
	@Test
	@DisplayName("ILoginServiceImpl::method should return user by password ")
	void testViewUser2() throws BMSException {
		UserEntity testdata = new UserEntity(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President");
		UserModel expected = new UserModel(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President");

		Mockito.when(userrepo.findByPassword(testdata.getPassword())).thenReturn(Optional.of(testdata).get());
		UserModel actual = lsImpl.getByPassword(testdata.getPassword());
		assertEquals(expected, actual);

	}

}