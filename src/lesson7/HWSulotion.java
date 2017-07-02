package lesson7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HWSulotion {

	public static void main(String[] args) {
		int[] arr = new int[100];

		Random rand = new Random();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);

		}

		list = initList(arr);

		int sum = getSum(list);
		System.out.println("Sum of the list: " + sum);

		list = filterList(list);
	}

	public static int getSum(List<Integer> list) {

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i);
		}

		return sum;

	}

	public static List<Integer> initList(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		return list;

	}

	public static List<Integer> filterList(List<Integer> list) {
		int listSize = list.size();
		
		//sulotion 1
//		Iterator<Integer> itr=list.iterator();
//		
//		while(itr.hasNext()){
//			if(itr.next().intValue()%2!=0){
//				itr.remove();
//			}
//		}
		
		//sulotion 2
		
		List<Integer>newList=new ArrayList<Integer>();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i)%2==0){
				newList.add(list.get(i));
			}
		}

//		for (int i = 0; i < listSize; i++) {
//			System.out.println(list.get(i));
//
//			if (list.get(i) % 2 != 0) {
//				System.out.println("removing :" + list.get(i));
//				list.remove(i);
//				listSize--;
//
//			}
//		}

		return newList;
	}

}
