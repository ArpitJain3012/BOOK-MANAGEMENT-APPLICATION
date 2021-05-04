package com.capg.bsma.service;

import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.UserModel;

public interface ILoginService {
	
	public UserModel addUser(UserModel user )throws BMSException;
	public boolean removedUser(Long userid )throws BMSException;
	public UserModel updateUser(UserModel user )throws BMSException;
	public UserModel getById(Long id) throws BMSException;
	public UserModel getByPassword(String password) throws BMSException;

}
