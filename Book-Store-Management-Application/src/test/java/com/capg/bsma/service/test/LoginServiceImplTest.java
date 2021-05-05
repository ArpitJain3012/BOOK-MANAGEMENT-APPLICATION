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
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.exception.BMSException;
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
		UserModel expected = new UserModel(101L, "arpit@gmail.com", "arpit1234", "President");

		Mockito.when(userrepo.existsById(testdata.getUserId())).thenReturn(false);

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

		Mockito.when(userrepo.existsById(testdata.getUserId())).thenReturn(true);

		Mockito.when(userrepo.save(testdata)).thenReturn(testdata);
		UserModel actual = lsImpl.updateUser(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test Case 4 -view user by id
	 */
	@Test
	@DisplayName("ILoginServiceImpl::method should return user by id ")
	void testViewUser() throws BMSException {
		UserEntity testdata = new UserEntity(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President");
		UserModel expected = new UserModel(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President");

		Mockito.when(userrepo.findById(testdata.getUserId())).thenReturn(Optional.of(testdata));
		UserModel actual = lsImpl.getById(testdata.getUserId());
		assertEquals(expected, actual);

	}

	/**
	 * Test case - retrieving list of user
	 */
	@Test
	@DisplayName("IUserServiceImpl::listalluser should return list of existing user details from database")
	void testListAllUser() throws BMSException {

		// entering mock values into the Entity constructor
		List<UserEntity> testdata = Arrays.asList(
				new UserEntity[] { new UserEntity(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President") });

		// find all method is called
		Mockito.when(userrepo.findAll()).thenReturn(testdata);

		// entering mock values into the Model constructor
		List<UserModel> expected = Arrays
				.asList(new UserModel[] { new UserModel(1004L, "arpit@gmail.com", "arpitjain1235", "Vice-President") });

		List<UserModel> actual = lsImpl.listUsers();
		assertEquals(expected, actual);
	}

}