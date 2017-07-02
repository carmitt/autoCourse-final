package lesson7;

public class TryCatch {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try{
		
		int[] arr = new int[] { 1, 3, 4, 5 };

		System.out.println(arr[8]);
		// do something - db access, send http req etc...
		}
		catch(Exception e){
			System.out.println(e.toString());
		}

	}

}
