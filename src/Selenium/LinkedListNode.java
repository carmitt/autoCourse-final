package Selenium;

public class LinkedListNode {

	String value;

	LinkedListNode next;

	LinkedListNode prev;
	
	LinkedListNode parallell;

	public LinkedListNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public LinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(LinkedListNode prev) {
		this.prev = prev;
	}

	public LinkedListNode getParallell() {
		return parallell;
	}

	public void setParallell(LinkedListNode parallell) {
		this.parallell = parallell;
	}

}
