package lesson3;

public class MainClassLesson3 {
	
	public static void main(String[]args){
		
		Taxi taxi1=new Taxi(4, "diesel", 2017, "5554344");
		
		Taxi taxi2=new Taxi(4, "diesel", 2016, "44444", 22223, "alenby", 7);
		
	
		taxi1.drive(100);
		
		taxi1.setWheels(6);
		
		System.out.println(taxi1.getWheels());
		
		
		
	
		
		
		
	}

}
