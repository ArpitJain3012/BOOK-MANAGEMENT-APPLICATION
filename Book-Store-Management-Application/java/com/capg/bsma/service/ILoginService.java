package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.UserModel;

public interface ILoginService {
	// add users in database
	public UserModel addUser(UserModel user) throws BMSException;

	// remove users from database
	public boolean removedUser(Long userid) throws BMSException;

	// update users in database
	public UserModel updateUser(UserModel user) throws BMSException;

	// view users by user id
	public UserModel getById(Long id) throws BMSException;

	// list user details
	public List<UserModel> listUsers() throws BMSException;

}
