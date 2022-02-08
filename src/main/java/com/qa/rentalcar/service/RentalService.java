package com.qa.rentalcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.rentalcar.domain.Rental;
import com.qa.rentalcar.repo.RentalRepo;


@Service
public class RentalService implements RentalServiceInterface<Rental> {
	
	private RentalRepo repo;
	
	public RentalService (RentalRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Rental create(Rental rental) {
		return this.repo.save(rental);
	}

	@Override
	public List<Rental> getAll() {
		
		return this.repo.findAll();
	}


	
	public Rental getById(int id) {
		
		Optional<Rental> optionalRental = this.repo.findById(id);
		return optionalRental.orElse(null);
	}
	

	@Override
	public Rental update(int id, Rental updatedRental) {
	
		Optional<Rental> optionalRental = this.repo.findById(id);
		if (optionalRental.isPresent()) {
			Rental existingRental = optionalRental.get();
			existingRental.setClienId(updatedRental.getClienId());
			existingRental.setCarId(updatedRental.getCarId());
			existingRental.setClientName(updatedRental.getClientName());
	        existingRental.setCarType(updatedRental.getCarType());
	        existingRental.setCarBrand(updatedRental.getCarBrand());
	        existingRental.setRentalPeriod(updatedRental.getRentalPeriod());
	        existingRental.setCarBack(updatedRental.isCarBack());
	        existingRental.setRentalCost(updatedRental.getRentalCost());
			
	        return existingRental;
			
		}
		return null;
	}
	
	
	

	@Override
	public boolean delete(int id) {
	
		this.repo.deleteById(id);
		boolean exists= this.repo.existsById(id);
		
		return !exists;
		
	}
	
	

}
