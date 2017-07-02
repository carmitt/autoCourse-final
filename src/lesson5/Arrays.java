package lesson5;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class Arrays {

	public static void main(String[] args) {

		String[] words = new String[5];
		
		int[]arr=new int[]{};
		
	

		String[] cities = new String[] { "haifa", "tel aviv", "bat yam", "tel aviv" };

		System.out.println(cities[0]);

		int counter = 0;

		for (int i = 0; i < cities.length; i++) {

			counter = counter + cities[i].length();
			// search for bat yam
			if (cities[i].equals("bat yam")) {
				cities[i] = "jerusalem";
			}
			// searces for the substring 'tel'
			if (cities[i].contains("tel")) {
				System.out.println("found tel");
				cities[i] = cities[i].replace("tel", "TTT");

			}

			System.out.println("after change: " + cities[i]);
		}
		
		
		List<String>strList=new ArrayList<String>();
		
		strList.add("ford");
		strList.add("aaaa");
		
		strList.add("aaaa");
		strList.add("fff");
		strList.add("fff66");
		strList.add("ddd");
		strList.add("dd");
		
		for(int k=0;k<strList.size();k++){
			System.out.println(strList.get(k));
			
			
			if(strList.get(k).equals("fff")){
				//this removes the item in k# index
				strList.remove(k);
				
				//this replaces the element in k# index
				strList.set(k, "ggg");
				
				System.out.println(strList.get(k));
			}
		}
		
		for(String str:strList){
			System.out.println(str);
		}

	}

}
