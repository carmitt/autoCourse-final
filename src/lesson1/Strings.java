package lesson1;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str;

		String nullStr = null;

		String empty = "";

		String spaces = "     ";

		String comp1 = new String("abcd");

		String comp2 = "abcd";
		
	

		compareStr(comp1, "abcd");
		
		
		String concat="abca";
		concat=concat+"dfg";
		
		char a=concat.charAt(2); //get char in specific index
		
	System.out.println(concat.indexOf("a"));	;

	}

	public static void compareStr(String a, String b) {
		if (a == b) {
			System.out.println("ok==");
		}

		if (a.equals(b)) {
			System.out.println("ok equals");
		}
	}

}
