package lesson5;

public class SwitchClass {

	public static void main(String[] args) {
//		printStatusCode(400);
//		
//		printStatusCode(500);
//		
//		printStatusCode(999);
		
		switchString("a");
		
		switchString("b");
		
		switchString("c");
		
		switchString(null);
	}

	public static void switchString(String str){
		switch (str) {
		case "a":
			System.out.println("a");
			
			break;
		case "b":
			System.out.println("b");
			break;
		default:
			
			System.out.println("default");
			break;
		}
	}
	
	public static void printStatusCode(int statusCode) {

		// 200,400,401,500,502,404
		switch (statusCode) {
		case 200:
			System.out.println("ok");
			
			break;
		case 400:
			System.out.println("error 400 found");
			break;
		case 500:
			System.out.println("error 500");
			break;
		default:
			System.out.println("no known error");
			break;
		}
	}

}
