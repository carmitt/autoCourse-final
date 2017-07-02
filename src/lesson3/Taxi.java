package lesson3;

public class Taxi extends Vehicle {

	private int taxiNumber;

	private String stationName;

	private int numberOfPassengers;

	double fair;

	/**
	 * 
	 * @param wheels
	 * @param engine
	 * @param year
	 * @param licenseNumber
	 * @param taxiNumber
	 * @param stationName
	 * @param numberOfPassengers
	 */
	public Taxi(int wheels, String engine, int year, String licenseNumber, int taxiNumber, String stationName,
			int numberOfPassengers) {
		super(wheels, engine, year, licenseNumber);
		this.taxiNumber = taxiNumber;
		this.stationName = stationName;
		this.numberOfPassengers = numberOfPassengers;
	}

	/**
	 * 
	 * @param wheels
	 * @param engine
	 * @param year
	 * @param licenseNumber
	 */
	public Taxi(int wheels, String engine, int year, String licenseNumber) {
		super(wheels, engine, year, licenseNumber);

	}

	public int getTaxiNumber() {
		return taxiNumber;
	}

	public void setTaxiNumber(int taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	
	public void drive(int km) {
		
		super.drive(km);
		
		System.out.println("Taxi drive");
	}

	

	// public void drive(int km){
	//
	// }

}
