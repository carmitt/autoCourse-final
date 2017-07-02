package Selenium;

import java.util.LinkedList;

import org.junit.Test;

import enums.ByTypes;

public class SeleniumAdv extends BasicTest {

	@Test
	public void testUpload() {

		webdriver.openUrl("http://the-internet.herokuapp.com/upload");
		webdriver.getElementBy(ByTypes.id, "file-upload")
				.sendKeys(System.getProperty("user.dir") + "\\files\\headerHtml.txt");

		System.out.println("");

		;
	}

	@Test
	public void testTabs() {
		webdriver.openUrl("http://the-internet.herokuapp.com/windows");

//		webdriver.getElementBy(type, value);

		// move to new tab
	}

	@Test
	public void linkedList() {
		LinkedList<String> list = new LinkedList<String>();

		list.add("one");

		list.add("two");

		list.add("three");

		System.out.println(list.getLast());
		
		list.add("four");
		
		System.out.println(list.getLast());
		
		list.add(0, "five");
		
		System.out.println(list.getLast());
		
		System.out.println(list.get(0));
		
		System.out.println(list.contains("five"));
		
		list.remove("five");
		
		System.out.println(list.contains("five"));
		
		
		
		
	}

}
