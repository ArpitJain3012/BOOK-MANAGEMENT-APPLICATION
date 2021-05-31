package com.capg.bsma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.model.UserModel;
import com.capg.bsma.repo.ICustomerRepository;
import com.capg.bsma.repo.ILoginRepository;

/*
 * implementing parser method to link entity with model
 */
@Service
public class EMParserUser {
	/*
	 * Login Repository is Autowired
	 */
	@Autowired
	private ILoginRepository loginRepo;
	/*
	 * Customer Repository is Autowired
	 */
	@Autowired
	private ICustomerRepository custRepo;
	/*
	 * Default constructor
	 */

	public EMParserUser() {

	}

	/*
	 * Parameterized constructor
	 */

	public EMParserUser(ILoginRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}

	/*
	 * link entity with model
	 */
	public UserEntity parse(UserModel source) {
		return source == null ? null
				: new UserEntity(source.getUserId(), source.getEmail(), source.getPassword(), source.getRole(),
						custRepo.findById(source.getCustomerId()).orElse(null));
	}

	/*
	 * link model with entity
	 */
	public UserModel parse(UserEntity source) {
		return source == null ? null
				: new UserModel(source.getUserId(), source.getEmail(), source.getPassword(), source.getRole(),
						source.getCustomer().getCustomerId());

	}

}
