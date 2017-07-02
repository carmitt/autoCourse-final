package lesson5;

import java.util.Random;

public class HW_sulotion {
	
	public static void main(String[]args){
//int []arr=new int[20];
//		
//		int groupA=0;
//		int groupB=0;
//		int groupC=0;
//		int groupD=0;
//		
//		Random random=new Random();
//		
//		for(int i=0;i<arr.length;i++){
//			//enter a random number into the array
//			arr[i]=Math.abs(random.nextInt(120)) ;
//			
//			if(arr[i]>=0 && arr[i]<=24){
//				groupA++;
//			}
//			else if(arr[i]>24 && arr[i]<=49){
//				groupB++;
//			}
//			else if(arr[i]>49 && arr[i]<=74){
//				groupC++;
//			}
//			else if(arr[i]>=75 && arr[i]<=100){
//				groupD++;
//			}
//			else{
//				System.out.println("Number is bigger then 100");
//			}
//		}
//		
//		System.out.println("Group a: "+groupA);
//		System.out.println("Group b: "+groupB);
//		System.out.println("Group c: "+groupC);
//		System.out.println("Group b: "+groupD);
		
		
		
		String str = "Sel0WxxvHDxzgehmrs0ueAsPLxoqVbEAXwHAk0FUx";

		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				System.out.println("Zero found! at index: " + i);
				System.out.println(str.substring(0, i+1));
			}
		}



	}

}
