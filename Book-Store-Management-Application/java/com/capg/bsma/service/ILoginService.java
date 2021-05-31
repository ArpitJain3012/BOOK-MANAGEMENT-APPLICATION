package com.capg.bsma.service;

import java.util.List;

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.UserModel;

public interface ILoginService {
	/* definition of signIn method for signing in */
	public UserModel signIn(String email, String password) throws BMSException;
	
	/* definition of addUser method for registering a user*/
	public UserModel addUser(UserModel login) throws BMSException;
	

	/* definition of signOut method for signing out */
	public boolean signOut(UserModel login) throws BMSException;
	

}
