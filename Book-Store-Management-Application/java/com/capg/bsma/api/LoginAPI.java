package com.capg.bsma.api;

import java.util.List;

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
import com.capg.bsma.service.ILoginService;
import com.capg.bsma.service.LoginServiceImpl;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin
public class LoginAPI {

	/*
	 * Login Service is Autowired 
     */
	
	@Autowired
	private ILoginService loginService;

	/*
	 * to login
	 * params : userId
	 */
	
	@PostMapping("/signin")
	public ResponseEntity<UserModel> user(@RequestBody UserModel login) throws BMSException {
		String tempUserEmail = login.getEmail();
		String tempPassword = login.getPassword();
		if(tempUserEmail != null && tempPassword !=null ) {
			login=loginService.signIn(tempUserEmail, tempPassword);
		}if(login == null) {
			throw new BMSException("Bad Credentials");
		}
		return new ResponseEntity<>(login,HttpStatus.OK);

	}
	
	/*
	 * to register new user
	 * params : login
	 */
	
	@PostMapping
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel login) throws BMSException {
		login = loginService.addUser(login);
		return new ResponseEntity<>(login, HttpStatus.CREATED);
		
	}

}
