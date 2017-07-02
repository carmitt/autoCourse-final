package lesson3;

public class Vehicle {

	private int wheels;

	private String engine;

	private int year;

	private String licenseNumber;

	private int spareWheels;

	// constructor
	public Vehicle(int wheels, String engine, int year, String licenseNumber) {
		super();
		this.wheels = wheels;
		this.engine = engine;
		this.year = year;
		this.licenseNumber = licenseNumber;
	}
	
	public Vehicle(){
		
	}

	// getter and setters

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void drive(int km) {
		System.out.println("vehicle was driving for " + km + " km");
	}

	public int getSpareWheels() {
		return spareWheels;
	}

	public void setSpareWheels(int spareWheels) {
		this.spareWheels = spareWheels;
	}

	public int getNumberOfSpareWheels() {
		spareWheels=wheels/4;
		
		return spareWheels;
		
		
	}

}
