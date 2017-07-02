package Selenium;

import org.junit.Test;

public class Selenium4Tests extends BasicTest {

	@Test
	public void testDragAndDrop() {
		webdriver.openUrl("http://www.elated.com/res/File/articles/development/javascript/jquery/drag-and-drop-with-jquery-your-essential-guide/draggable.html");

		webdriver.dragAndDrop("//div[@id='makeMeDraggable']", "//div[@class='wideBox']");
		
		webdriver.printScreen("after drag");
	}
	
	@Test
	
	public void switchToFrame() throws Exception{
		webdriver.openUrl("https://the-internet.herokuapp.com/iframe");
		
		webdriver.swithcToFrameAndSendKeys("//body[@id='tinymce']//p", "aaaa", true, "mce_0_ifr");
	}
	
	@Test
	public void testPrintInterface(){
		IPrinter printer;
		
		printer=new ColorPrinterImpl();
		
		
	}
	
	@Test
	public void testLogs(){
		webdriver.openUrl("http://www.ynet.co.il");
	}

}
