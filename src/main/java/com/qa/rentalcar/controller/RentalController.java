package com.qa.rentalcar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rentalcar.domain.Rental;
import com.qa.rentalcar.service.RentalServiceInterface;


@RestController
@RequestMapping("/rental")
public class RentalController {

private RentalServiceInterface<Rental> service;
	
	public RentalController (RentalServiceInterface<Rental> service) {
		this.service = service;
	}
	

	
	@PostMapping("/create")
	public ResponseEntity<Rental> createDuck(@RequestBody Rental rental){
		return new ResponseEntity<Rental>(this.service.create(rental), HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





