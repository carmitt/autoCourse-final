package lesson5;

import java.util.Random;

import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;

public class WhileClass {

	public static void main(String[] args) throws InterruptedException {

//		int elapsedTime = 0;
//		int timeout = 10;
//		boolean db = false;
//
//		int counter = 0;
//
//		while (elapsedTime < timeout) {
//			if (isDbUpdated() == true) {
//				// elapsedTime=timeout;
//				db = true;
//				System.out.println("DB updated");
//				counter++;
//				if (counter == 1) {
//					continue;
//				} else {
//					break;
//				}
//			} else {
//				Thread.sleep(1000);
//				System.out.println("Sleeping for 1000ms");
//				elapsedTime++;
//
//			}
//		}
//
//		System.out.println("end of while loop");
//
//		System.out.println(db);
		
		
		whileLoop();
	}

	private static boolean isDbUpdated() {
		Random rand = new Random();
		if (rand.nextInt(1000) > 500) {
			return true;
		} else
			return false;
	}

	public static void whileLoop() throws InterruptedException {

		int counter = -10;

		while (counter < 20) {
			counter = counter + 1;
			Thread.sleep(1000);
			
			System.out.println("Counter= "+counter);
			
			
		}

	}

}
