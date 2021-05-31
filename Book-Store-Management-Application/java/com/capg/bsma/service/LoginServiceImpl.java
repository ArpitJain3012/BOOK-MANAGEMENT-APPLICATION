package com.capg.bsma.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.UserModel;
import com.capg.bsma.repo.ILoginRepository;
/*
 * implementing service method for customer
 */

@Service
public class LoginServiceImpl implements ILoginService {

	public static final String NOT_FOUND = "no user with id #";
	public static final String PRESENT = " present";

	/*
	 * Login Repository is Autowired
	 */

	@Autowired
	private ILoginRepository loginRepository;

	/*
	 * EMParserLogin is Autowired
	 */

	@Autowired
	private EMParserUser parser;

	/*
	 * Default Constructor
	 */

	public LoginServiceImpl() {
		this.parser = new EMParserUser();
	}

	/*
	 * Parameterized constructor for assigning
	 */

	public LoginServiceImpl(ILoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
		this.parser = new EMParserUser();
	}

	/*
	 * Implementation of signIn method to signIn a user
	 */

	@Override
	public UserModel signIn(String email, String password) throws BMSException {
		return parser.parse(loginRepository.findByEmailAndPassword(email, password));
	}

	/*
	 * Implementation of signOut method to signOut a user
	 */

	@Override
	public boolean signOut(UserModel login) throws BMSException {
		// implementation is done during front end
		return false;
	}

	@Override
	public UserModel addUser(UserModel login) throws BMSException {

		if (login.getUserId() == null) {
			throw new BMSException(NOT_FOUND + login.getUserId() + PRESENT);
		} else {

			login = parser.parse(loginRepository.save(parser.parse(login)));
		}
		return login;
	}
}
