package Selenium;

import java.util.LinkedList;

public class LinkedLists {

	public static void main(String args) {
		LinkedListNode node1 = new LinkedListNode("ooo");

		LinkedListNode node2 = new LinkedListNode("xsss");

		LinkedListNode node3 = new LinkedListNode("ggg");
		
		
		
		LinkedListNode newListNode1=new LinkedListNode("***");
		
		node3.setParallell(newListNode1);
		

		node1.setNext(node2);

		node2.setNext(node3);

		node3.setNext(node1);
		
		//node3.setPrev(node2);
	}

}
