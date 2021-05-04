package com.capg.bsma.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.UserModel;
import com.capg.bsma.repo.ILoginRepository;
import com.capg.bsma.repo.IReviewRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginRepository ilr;

	@Autowired
	private EMParserUser parser;

	public LoginServiceImpl() {
		this.parser = new EMParserUser();
	}

	public LoginServiceImpl(ILoginRepository ilr) {
		super();
		this.ilr = ilr;
		this.parser = new EMParserUser();
	}

	@Transactional
	@Override
	/*
	 * addUseris used to add user so that new user can use bsma
	 */
	public UserModel addUser(UserModel user) throws BMSException {

		if (user != null) {
			if (ilr.existsById(user.getUserId())) {

				throw new BMSException("User with given Id already exists");
			} else {
				user = parser.parse(ilr.save(parser.parse(user)));
			}

		}
		return user;
	}

	@Transactional
	@Override
	/*
	 * removeUser is use to remove user from bsma
	 */
	public boolean removedUser(Long userid) throws BMSException {

		UserEntity user = ilr.findById(userid).orElse(null);
		if (user == null) {
			throw new BMSException("no user with id # " + userid + " present");
		} else {
			ilr.deleteById(userid);
		}
		return true;
	}

	@Transactional
	@Override
	/*
	 * updateUser is used to update user info and print message after completion.
	 */
	public UserModel updateUser(UserModel user) throws BMSException {
		if (user != null) {
			if (!ilr.existsById(user.getUserId())) {
				throw new BMSException("No such user here");
			}
			user = parser.parse(ilr.save(parser.parse(user)));
		}
		return user;
	}

	/*
	 * getById is use to get user Id from bsma
	 */
	@Override
	public UserModel getById(Long id) throws BMSException {
		if (ilr.existsById(id))
			throw new BMSException("No user found for the given id");
		return parser.parse(ilr.findById(id).get());
	}

	/*
	 * getByPassword is use to get password from user in bsma
	 */
	@Override
	public UserModel getByPassword(String password) throws BMSException {
		if (ilr.existsByPassword(password))
			throw new BMSException("No user found for the given password");
		return parser.parse(ilr.findByPassword(password));
	}
}
