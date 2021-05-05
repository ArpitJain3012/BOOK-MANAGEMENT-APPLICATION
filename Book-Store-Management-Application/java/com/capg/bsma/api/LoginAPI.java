package com.capg.bsma.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.capg.bsma.service.LoginServiceImpl;

@RestController
@RequestMapping(path = "/user")
public class LoginAPI {

	@Autowired
	private LoginServiceImpl lsimpl;

	/*
	 * to retrieve all cuser return : List<userr> params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<UserModel>> findAllUserAction() throws BMSException {
		return new ResponseEntity<>(lsimpl.listUsers(), HttpStatus.OK);
	}

	/*
	 * user id should be alpha numerical and between 1-10
	 */

	@GetMapping("/{userId}")
	public ResponseEntity<UserModel> getById(@PathVariable("userId") Long id) throws BMSException {
		return ResponseEntity.ok(lsimpl.getById(id));
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
