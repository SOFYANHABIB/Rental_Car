package com.qa.rentalcar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.rentalcar.domain.Rental;


public interface RentalRepo extends JpaRepository<Rental , Integer>{
	

}
