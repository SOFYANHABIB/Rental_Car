package com.qa.rentalcar.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class RentalUnitTest {
	
	@Test
    public void testEquals() {
        EqualsVerifier.forClass(Rental.class).usingGetClass()
        .withPrefabValues(Rental.class, new Rental(8, 5, "Mehdi", "small", "KIA", 5, false, 80.5F), new Rental()).verify();
    }
	
	@Test
	public void testConstructorwithId() {
		Rental rental = new Rental (1, 8, 5, "Mehdi", "small", "KIA", 5, false, 80.5F);
		//If this has been constructed and the values have been placed in
		//Then nothing inside of here should be null
		assertNotNull(rental.getId());
		assertNotNull(rental.getClienId());
		assertNotNull(rental.getCarId());
		assertNotNull(rental.getClientName());
		assertNotNull(rental.getCarType());
		assertNotNull(rental.getCarBrand());
		assertNotNull(rental.getRentalPeriod());
		assertNotNull(rental.isCarBack());
		assertNotNull(rental.getRentalCost());
		
		
		assertEquals(1, rental.getId());
		assertEquals(8, rental.getClienId());
		assertEquals(5, rental.getCarId());
		assertEquals("Mehdi", rental.getClientName());
		assertEquals("small", rental.getCarType());
		assertEquals("KIA", rental.getCarBrand());
		assertEquals(5, rental.getRentalPeriod());
		assertEquals(false, rental.isCarBack());
		assertEquals(80.5F, rental.getRentalCost() , 0.01);

		
	}

	
	
	

}
