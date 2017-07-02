package lesson4;

import java.util.Random;

public class ForLoops {

	public static void main(String[] args) throws InterruptedException {

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;

			// System.out.print(arr[i]);
		}

		;

		// System.out.println(getArrContent(arr));

		String[] strArr = new String[] { "aaaa", "bbb", "ccc", null, "" };
		
		Random rand=new Random();
		
		rand.nextInt(10);
		
		
		
		
		

		String result = "";

		for (int i = 0; i < strArr.length; i++) {

			System.out.println("Starting outer loop. i=" + i);

			for (int j = 0; j < 50; j++) {

				System.out.println("Starting inner loop. j=" + j);

				Thread.sleep(200);
				System.out.println("Sleeping for 200 ms");

				System.out.println(i * j);

				
			}

		}

		// System.out.println(result);

	}

	public static String getArrContent(int[] arr) {
		String str = "";

		for (int i = 0; i < arr.length; i++) {
			str = str + arr[i] + " ";
		}

		return str;
	}

}
