package com.capg.bsma.api;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bsma.exception.BMSException;

@RestController
@RequestMapping(path = "/")
public class DefaultController {
	
	@GetMapping
	public ResponseEntity<String> defaultAction() {
		return new ResponseEntity<>(".........................Welcome To Book Store Mnagement Application.........................", HttpStatus.OK);
	}

}
