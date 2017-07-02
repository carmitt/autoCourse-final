package lesson8;

public class SuperClass {

	public static class autoUtils {
		
		
		public static class stamUtils{
			
		}

		public static String flipString(String str) {
			String temp = "";
			for (int i = str.length() - 1; i >= 0; i--) {
				temp += str.charAt(i);
			}
			return temp;
		}

	}

}
