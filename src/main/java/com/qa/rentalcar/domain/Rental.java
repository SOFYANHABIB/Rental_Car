package com.qa.rentalcar.domain;


	import java.util.Objects;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


	   @Entity
	   @Table(name = "rental")
	   public class Rental {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private int id;
		
		
		@Column
		private int clienId;
		
		@Column
		private int carId;
		
        @NotNull(message = "Please enter a name")
		@Column
		private String clientName;
		
		@Column
		private String carType;
		
		@Column
		private String carBrand;
		@Min(0)
		@Max(365)
		@Column
		private int rentalPeriod;
		
		@Column
		private  boolean carBack;
		
		@Column
		private float rentalCost;

	
		// Default constructor
		public Rental() {
			super();
		}


		
		//Constructor without id for customer view
		public Rental(int clienId, int carId, String clientName, String carType, String carBrand, int rentalPeriod,
				boolean carBack, float rentalCost) {
			super();
			this.clienId = clienId;
			this.carId = carId;
			this.clientName = clientName;
			this.carType = carType;
			this.carBrand = carBrand;
			this.rentalPeriod = rentalPeriod;
			this.carBack = carBack;
			this.rentalCost = rentalCost;
		}


	    //Constructor with id for admin view
		public Rental(int id, int clienId, int carId, String clientName, String carType, String carBrand, int rentalPeriod,
				boolean carBack, float rentalCost) {
			super();
			this.id = id;
			this.clienId = clienId;
			this.carId = carId;
			this.clientName = clientName;
			this.carType = carType;
			this.carBrand = carBrand;
			this.rentalPeriod = rentalPeriod;
			this.carBack = carBack;
			this.rentalCost = rentalCost;
		}

	
	
	
	
	
	
	
	
}
