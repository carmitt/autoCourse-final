package lesson4;

import java.util.ArrayList;
import java.util.List;

public class Lists {
	
	
	public void listsSample(){
		
		List<String>list=new ArrayList<String>();
		
		
		list.add("aaaaa");
		list.add("bbbbb");
		list.add("ccccc");
		list.add("ddddd");
		list.add("fffff");
		list.add("hhhhh");
		
		
		for(String str:list){
			System.out.println(str);
		}
	}

}
