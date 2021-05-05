package com.capg.bsma.service;

import org.springframework.stereotype.Service;

import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.model.UserModel;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserUser {
	/*
	 * link entity with model
	 */
	public UserEntity parse(UserModel source) {
		return source == null ? null
				: new UserEntity(source.getUserId(), source.getEmail(), source.getPassword(), source.getRole());
	}

	/*
	 * link model with entity
	 */
	public UserModel parse(UserEntity source) {
		return source == null ? null
				: new UserModel(source.getUserId(), source.getEmail(), source.getPassword(), source.getRole());

	}

}
