package QA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of numbers, except for one number all the others, occur twice.
//What should be the algorithm to find that number which occurs only once in the array?
//Example :a[1..n] = [1,2,3,4,3,1,2]

public class pali {

	public static void main(String[] args) {
		System.out.println(isPalindrom("abcdcba"));

//		System.out.println(isPalindrom("aa1a"));
//
//		System.out.println(isPalindrom("1234321"));
//
//		System.out.println(getOneAccurance(new int[] { 1, 5, 3, 5, 1, 2, 2 }));
//		
//		System.out.println(isAnadram("qwerty", "yqtwre"));
//		
//		System.out.println(isAnadram("qwerty", "yqttwre"));
	}

	public static boolean isPalindrom(String str) {

		System.out.println(str);
		if (str.length() == 0 || str.length() == 1) {
			return true;
		} else {
			if (str.charAt(0) == str.charAt(str.length() - 1)) {
				System.out.println(str.charAt(1));
				System.out.println(str.charAt(-1));
				
				return isPalindrom(str.substring(1, str.length() - 1));
				
				
			}
		}
		return false;
	}

	// What is the differences between an interface and an abstract class

	public static int getOneAccurance(int[] numbers) {
		Map<Integer, Integer> accur = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			if (accur.containsKey(numbers[i])) {
				accur.put(numbers[i], accur.get(numbers[i]) + 1);
			} else {
				accur.put(numbers[i], 1);
			}
		}

		for (Integer keys : accur.keySet()) {
			if (accur.get(keys) == 1) {
				return keys;
			}
		}
		return Integer.MIN_VALUE;

	}

	public static boolean isAnadram(String str1, String str2) {
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();

		Arrays.sort(charArr1);
		Arrays.sort(charArr2);

		if (Arrays.equals(charArr1, charArr2)) {
			return true;
		} else
			return false;
	}

}
