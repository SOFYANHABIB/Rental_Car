package com.qa.rentalcar.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	
	
	
	
	
	
}
