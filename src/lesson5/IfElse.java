package lesson5;

public class IfElse {

	public static void main(String[] args) {

		String str = "abcdaaaaaa";
		String strA = "abcd";

		int one = 1;
		int two = 2;

		//&& - and
		
		// || or
		
		// == equals
		
		// != not equals
		
		if (str.equals(strA) && one==two) {
			System.out.println("String are equal");
			if (one == two || one>2) {
				System.out.println("Integers are equal");
			}
			System.out.println("Integers are not the same");
		} else if (str.length() > 4) {
			System.out.println("Length of str is bigger then 4");
		}
		else{
			
		}

	}

}
