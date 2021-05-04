package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.model.UserModel;
import com.capg.bsma.repo.ILoginRepository;

@Service
public class EMParserUser {
	

	@Autowired
	private ILoginRepository ilr;

	public UserEntity parse(UserModel source) {
		return source == null ? null
				: new UserEntity(source.getUserId(), source.getEmail(), source.getPassword(), source.getRole());
	}

	public UserModel parse(UserEntity source) {
		return source == null ? null
				: new UserModel(source.getUserId(), source.getEmail(), source.getPassword(), source.getRole());
		
	}

}
