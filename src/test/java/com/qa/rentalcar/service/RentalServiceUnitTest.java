package com.qa.rentalcar.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.rentalcar.domain.Rental;
import com.qa.rentalcar.repo.RentalRepo;





@SpringBootTest
@ActiveProfiles("test")
public class RentalServiceUnitTest {

    private Rental newRental;
	
	private Rental savedRental;

	@Autowired
	private RentalService service;
	
	
	@MockBean
	private RentalRepo repo;
	
	@BeforeEach
	void setUp() {
		
		newRental = new Rental(13, 18, "Joe", "luxury", "BMW", 5, false, 500.5F);
		savedRental = new Rental(1, 13, 18, "Joe", "luxury", "BMW", 5, false, 500.5F);
		
	}
	
	//CREATE test
	@Test
	void createTest() {

		
		Mockito.when(this.repo.save(newRental)).thenReturn(savedRental);
		
		//assertEquals MockData
		
		assertEquals(savedRental, this.service.create(newRental));
		
		//Mockito verify
		
		Mockito.verify(this.repo, Mockito.times(1)).save(newRental);
		
		
	}
	
	
	//GET ALL 
		@Test 
		void getAllTest() {
			List<Rental> mockInput= new ArrayList<Rental>();
			
			Rental rental1 = new Rental(1, 15, 22, "Alina", "small", "Toyota", 2, false, 60.5F);
			mockInput.add(rental1);
			
			Rental rental2 = new Rental(2, 15, 22, "Alina", "small", "Toyota", 2, false, 60.5F);
			mockInput.add(rental2);
			
			this.repo.save(rental1);
			this.repo.save(rental2);
			
		
			
			Mockito.when(this.repo.findAll()).thenReturn(mockInput);
			
			
			assertEquals(mockInput, this.service.getAll());
			
			
			Mockito.verify(this.repo, Mockito.times(1)).findAll();		
		}
		
		
		//GetById test
		@Test 
		void getByIdTest() {
			
			Rental rental5 = new Rental(5, 7, 6, "Alexia", "van", "Opel", 3, true, 80.5F);
	        this.repo.save(rental5); 
	        
	        int validId  = 5;
	        
	        Optional<Rental> validRental = Optional.ofNullable(new Rental(5, 7, 6, "Alexia", "van", "Opel", 3, true, 80.5F));
	        
	        Mockito.when(this.repo.findById(validId)).thenReturn(validRental);
	        
	        assertEquals(validRental.get(), this.service.getById(validId));
	        
	        Mockito.verify(this.repo, Mockito.times(1)).findById(validId);
			
			
			
		}
		
		
		//UPDATE test
//		@Test
//		
//		void updateTest() {
//			
//			//given id and object
//			
//			int id = 1;
//			
//			//new rental to update
//			Rental toUpdate = new Rental(9, 12, "Elon", "SUV", "Tesla", 5, false, 260.60F);
//			
//			//optional rental
//			Optional<Rental> optRental = Optional.of(new Rental(id, 0, 0, null, null, null, 0, false, 0));
//			
//			//Updated rental
//			Rental updated = new Rental(id, toUpdate.getClienId(), toUpdate.getCarId(), toUpdate.getClientName(), toUpdate.getCarType(), toUpdate.getCarBrand(), toUpdate.getRentalPeriod(), toUpdate.isCarBack(), toUpdate.getRentalCost());
//			
//			//When
//			Mockito.when(this.repo.findById(id)).thenReturn(optRental);
//			Mockito.when(this.repo.save(updated)).thenReturn(updated);
//			
//			//Them
//			assertEquals(updated, this.service.update(id, toUpdate));
//			
//			//Verify
//			Mockito.verify(this.repo, Mockito.times(1)).save(updated);
//			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//			
//			
//				
//				
//			}
		
		//UPDATE test
		@Test
		
		void updateTest() {
			
		
			
			int id = 1;
			
			//new rental to update
			Rental toUpdate = new Rental(9, 12, "Elon", "SUV", "Tesla", 5, false, 260.60F);
			
			//optional rental
			Optional<Rental> optRental = Optional.of(new Rental(id, 0, 0, null, null, null, 0, false, 0));
			
			//Updated rental
			Rental updated = new Rental(id, toUpdate.getClienId(), toUpdate.getCarId(), toUpdate.getClientName(), toUpdate.getCarType(), toUpdate.getCarBrand(), toUpdate.getRentalPeriod(), toUpdate.isCarBack(), toUpdate.getRentalCost());
			
			//When
			Mockito.when(this.repo.findById(id)).thenReturn(optRental);
			Mockito.when(this.repo.save(updated)).thenReturn(updated);
			
			//Them
			assertEquals(updated, this.service.update(id, toUpdate));
			
			//Verify
		
			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			
			
				
				
			}
	
		
		//DELETE test
		@Test
		void deleteTest() {
			
			//given
			int id = 1;
			
			//When
			Mockito.when(this.repo.existsById(id)).thenReturn(true, false);
			
			//Then
			
			assertEquals(false, this.service.delete(id));
			
			//Verify
			Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
			Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
			
		}
	
	
	
	
	
	
	
	
	
}
