package com.capg.bsma.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bsma.exception.BMSException;
import com.capg.bsma.model.UserModel;
import com.capg.bsma.repo.ILoginRepository;
import com.capg.bsma.service.LoginServiceImpl;

@RestController
@RequestMapping(path = "/users")
public class LoginAPI {

	@Autowired
	private LoginServiceImpl lsimpl;

	@Autowired
	private ILoginRepository ilr;

	/*
	 * user id should be alpha numerical and between 1-10
	 */

	@GetMapping("/{userId:[a-zA-Z0-9]{1,10}}")
	public ResponseEntity<UserModel> getById(@PathVariable("userId") Long id) throws BMSException {
		return ResponseEntity.ok(lsimpl.getById(id));
	}

	/*
	 * password should be alpha numeri with spl. character and strength should be
	 * 8-20 characters
	 */
	@GetMapping("/{password:[a-zA-Z0-9!@_]{8,20}}")
	public ResponseEntity<UserModel> getByPassword(@PathVariable("password") String password) throws BMSException {
		return ResponseEntity.ok(lsimpl.getByPassword(password));
	}

	/*
	 * to add an user return : UserModel params : User object
	 */
	@PostMapping
	public ResponseEntity<UserModel> addUserAction(@RequestBody UserModel user) throws BMSException {
		user = lsimpl.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	/*
	 * to remove an user return : void params : user Id
	 */
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> removeByUserIdAction(@PathVariable("userId") Long userId) throws BMSException {
		Boolean res = lsimpl.removedUser(userId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res, HttpStatus.OK);
		return response;
	}

	/*
	 * to update an user return : User params : User
	 */
	@PutMapping
	public ResponseEntity<UserModel> updateUserAction(@RequestBody UserModel user) throws BMSException {
		user = lsimpl.updateUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}