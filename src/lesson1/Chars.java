package lesson1;

public class Chars {
	
	
	
	
	
	public static void main(String[] args) {
		char a='a';
		char b='b';
		
		char c=a;
		
		
		System.out.println(a+" "+b+" "+c);
		
		printStringChars("efewfewfewfewfewewgfew");
		
	}
	
	public static void printStringChars(String str){
		for(int i=0;i<str.length();i++){
			System.out.println(str.charAt(i));
		}
	}

}
