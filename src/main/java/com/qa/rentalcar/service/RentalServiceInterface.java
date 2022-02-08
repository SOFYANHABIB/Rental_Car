package com.qa.rentalcar.service;

import java.util.List;

public interface RentalServiceInterface<T> {
	
	//CREATE METHOD
		T create(T t);
		
		//READ ALL
		List<T> getAll();
		
		//READ BY ID
		T getById(int id);
		
		//UPDATE 
		T update(int id, T t);
		
		//DELETE 
		
		boolean delete(int id);

}
