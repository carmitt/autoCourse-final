package lesson2;

import lesson3.Vehicle;

public class Truck extends Vehicle {

	public Truck(int wheels, String engine, int year, String licenseNumber) {
		super(wheels, engine, year, licenseNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Truck(){
		
	}

	
	
	int allowedWeight;

	String licenseType;

	int numberOfTrailers;

	public int getNumberOfSpareWheels() {

		int spareWheels = this.getWheels() / 2;

		setSpareWheels(spareWheels);
		
		return spareWheels;

	}

}
