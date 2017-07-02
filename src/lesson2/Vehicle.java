package lesson2;

public class Vehicle {

	String color;
	
	int milage;
	
	int year;
	
	int id;
	
	public int calsMilagePerYear(){
		int currentyear=getCurrentYear();
		
		int yearsPassed=currentyear-year;
		
		return milage/yearsPassed;
	}
	
	private int getCurrentYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addMilage(int milToAdd){
		this.milage+=milToAdd;
	}

	

	double length;

	double width;

	int numberOfWeels;

	boolean hasEngine;

	void move() {
		System.out.println("moving like a vehicle");
	}

	public Vehicle() {

	}

	public Vehicle(String color, int numOfWheels) {
		this.color = color;
		this.numberOfWeels = numOfWheels;
	}

	public void setId(int id) {
		this.id=id;
		
	}
	
	

}
