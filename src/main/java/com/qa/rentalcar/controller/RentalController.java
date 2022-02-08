package com.qa.rentalcar.controller;

import java.util.List;

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
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rental>> getAllDuck (){
		return new ResponseEntity<List<Rental>>(this.service.getAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Rental> getByIdDuck (@PathVariable int id){
		return new ResponseEntity<Rental>(this.service.getById(id), HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Rental> updateDuck (@PathVariable int id, @RequestBody Rental rental){
		return new ResponseEntity<Rental>(this.service.update(id, rental), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteDuck (@PathVariable int id){
	
		boolean deleted = this.service.delete(id);
		
		return (deleted) ? new ResponseEntity<Boolean>(deleted, HttpStatus.OK) : new ResponseEntity<Boolean>(deleted, HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





